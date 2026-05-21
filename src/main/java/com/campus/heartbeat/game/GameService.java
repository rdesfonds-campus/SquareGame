package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;

import java.util.UUID;

public interface GameService {
    Game createGame(String gameType, int playerCount, int boardSize);
    Game getGame(UUID gameId);
    Game playMove(UUID gameId, String tokenName, int x, int y) throws InvalidPositionException;
}