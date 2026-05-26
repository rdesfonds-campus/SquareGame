package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;
    private final MessageSource messageSource;

    @Value("${game.default-size}")
    private int defaultSize;

    @Value("${game.default-players}")
    private int defaultPlayers;

    public GameController(GameService gameService, MessageSource messageSource) {
        this.gameService = gameService;
        this.messageSource = messageSource;
    }

    @PostMapping
    public Map<String, Object> createGame(@RequestParam String gameType,
                                          @RequestParam(required = false) Integer playerCount,
                                          @RequestParam(required = false) Integer boardSize,
                                          Locale locale) {
        int players = playerCount != null ? playerCount : defaultPlayers;
        int size = boardSize != null ? boardSize : defaultSize;
        Game game = gameService.createGame(gameType, players, size);
        String message = messageSource.getMessage("game.created", null, locale);
        return Map.of("message", message, "game", game);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable UUID id) {
        return gameService.getGame(id);
    }

    @PostMapping("/{id}/tokens/{tokenName}")
    public Game playMove(@PathVariable UUID id,
                         @PathVariable String tokenName,
                         @RequestParam int x,
                         @RequestParam int y) throws InvalidPositionException {
        return gameService.playMove(id, tokenName, x, y);
    }
}