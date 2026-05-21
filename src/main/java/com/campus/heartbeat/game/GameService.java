package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Collection;
import java.util.UUID;

public interface GameService {
    Game createGame(String gameType, int playerCount, int boardSize);
    Game getGame(UUID gameId);
}