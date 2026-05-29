package com.campus.heartbeat.game.dao;

import fr.le_campus_numerique.square_games.engine.Game;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface GameDao {
    Collection<Game> findAll();
    Optional<Game> findById(UUID gameId);
    Game save(Game game);
    void delete(UUID gameId);
}