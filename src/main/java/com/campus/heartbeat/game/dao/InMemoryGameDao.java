package com.campus.heartbeat.game.dao;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryGameDao implements GameDao {

    private final Map<UUID, Game> games = new HashMap<>();

    @Override
    public Collection<Game> findAll() {
        return games.values();
    }

    @Override
    public Optional<Game> findById(UUID gameId) {
        return Optional.ofNullable(games.get(gameId));
    }

    @Override
    public Game save(Game game) {
        games.put(game.getId(), game);
        return game;
    }

    @Override
    public void delete(UUID gameId) {
        games.remove(gameId);
    }
}