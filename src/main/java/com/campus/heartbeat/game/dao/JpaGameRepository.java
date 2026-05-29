package com.campus.heartbeat.game.dao;

import com.campus.heartbeat.game.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGameRepository extends JpaRepository<GameEntity, String> {
}