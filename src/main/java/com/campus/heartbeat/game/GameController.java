package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Game createGame(@RequestParam String gameType,
                           @RequestParam int playerCount,
                           @RequestParam int boardSize) {
        return gameService.createGame(gameType, playerCount, boardSize);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable UUID id) {
        return gameService.getGame(id);
    }
}