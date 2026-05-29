package com.campus.heartbeat.game.dao;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;

@Repository
public class JdbcGameDao implements GameDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Game> findAll() {
        // TODO
        return null;
    }

    @Override
    public Optional<Game> findById(UUID gameId) {
        // TODO
        return Optional.empty();
    }

    @Override
    public Game save(Game game) {
        jdbcTemplate.update(
                "INSERT INTO game (id, status) VALUES (?, ?) ON DUPLICATE KEY UPDATE status = ?",
                game.getId().toString(),
                game.getStatus().toString(),
                game.getStatus().toString()
        );
        return game;
    }

    @Override
    public void delete(UUID gameId) {
        jdbcTemplate.update("DELETE FROM game WHERE id = ?", gameId.toString());
    }
}