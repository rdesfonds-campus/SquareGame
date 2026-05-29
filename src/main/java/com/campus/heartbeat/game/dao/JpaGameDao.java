package com.campus.heartbeat.game.dao;

import com.campus.heartbeat.game.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class JpaGameDao implements GameDao {

    private final JpaGameRepository repository;
    private final Map<UUID, Game> cache = new HashMap<>();

    public JpaGameDao(JpaGameRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Game> findAll() {
        return cache.values();
    }

    @Override
    public Optional<Game> findById(UUID gameId) {
        return Optional.ofNullable(cache.get(gameId));
    }

    @Override
    public Game save(Game game) {
        cache.put(game.getId(), game);
        repository.save(toEntity(game));
        return game;
    }

    @Override
    public void delete(UUID gameId) {
        cache.remove(gameId);
        repository.deleteById(gameId.toString());
    }

    private GameEntity toEntity(Game game) {
        return new GameEntity(
                game.getId().toString(),
                game.getStatus().toString()
        );
    }
}