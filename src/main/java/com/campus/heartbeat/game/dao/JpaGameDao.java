package com.campus.heartbeat.game.dao;

import com.campus.heartbeat.game.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class JpaGameDao implements GameDao {

    private final JpaGameRepository repository;

    public JpaGameDao(JpaGameRepository repository) {
        this.repository = repository;
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
        GameEntity entity = toEntity(game);
        repository.save(entity);
        return game;
    }

    @Override
    public void delete(UUID gameId) {
        repository.deleteById(gameId.toString());
    }

    private GameEntity toEntity(Game game) {
        return new GameEntity(
                game.getId().toString(),
                game.getStatus().toString()
        );
    }
}