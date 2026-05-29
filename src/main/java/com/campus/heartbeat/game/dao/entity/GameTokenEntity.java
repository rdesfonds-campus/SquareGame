package com.campus.heartbeat.game.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game_token")
public class GameTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String gameId;

    @Column
    private String name;

    @Column
    private boolean overturned;

    @Column
    private Integer x;

    @Column
    private Integer y;

    public GameTokenEntity() {}

    public GameTokenEntity(String gameId, String name, boolean overturned, Integer x, Integer y) {
        this.gameId = gameId;
        this.name = name;
        this.overturned = overturned;
        this.x = x;
        this.y = y;
    }

    public Long getId() { return id; }
    public String getGameId() { return gameId; }
    public void setGameId(String gameId) { this.gameId = gameId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isOverturned() { return overturned; }
    public void setOverturned(boolean overturned) { this.overturned = overturned; }
    public Integer getX() { return x; }
    public void setX(Integer x) { this.x = x; }
    public Integer getY() { return y; }
    public void setY(Integer y) { this.y = y; }
}