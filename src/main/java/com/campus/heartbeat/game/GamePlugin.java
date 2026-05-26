package com.campus.heartbeat.game;

import java.util.Collection;
import java.util.UUID;

public interface GamePlugin {
    String getGameId();
    Collection<UUID> getPlayerIds(int playerCount);
}