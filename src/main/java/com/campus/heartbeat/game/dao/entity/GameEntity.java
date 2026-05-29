package com.campus.heartbeat.game.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    private String id;

    @Column
    private String status;

    public GameEntity() {}

    public GameEntity(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}