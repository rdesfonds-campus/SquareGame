package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final Map<UUID, Game> games = new HashMap<>();

    private final Collection<GameFactory> gameFactories;

    public GameServiceImpl(Collection<GameFactory> gameFactories) {
        this.gameFactories = gameFactories;
    }

    @Override
    public Game createGame(String gameType, int playerCount, int boardSize) {
        GameFactory factory = gameFactories.stream()
                .filter(f -> f.getGameFactoryId().equals(gameType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown game type: " + gameType));

        Game game = factory.createGame(playerCount, boardSize);
        games.put(game.getId(), game);
        return game;
    }

    @Override
    public Game getGame(UUID gameId) {
        return games.get(gameId);
    }
}