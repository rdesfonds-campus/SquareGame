package com.campus.heartbeat.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.Token;
import com.campus.heartbeat.game.dao.GameDao;

import java.util.Collection;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;
    private final Collection<GameFactory> gameFactories;

    public GameServiceImpl(GameDao gameDao, Collection<GameFactory> gameFactories) {
        this.gameDao = gameDao;
        this.gameFactories = gameFactories;
    }

    @Override
    public Game createGame(String gameType, int playerCount, int boardSize) {
        GameFactory factory = gameFactories.stream()
                .filter(f -> f.getGameFactoryId().equals(gameType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown game type: " + gameType));
        Game game = factory.createGame(playerCount, boardSize);
        return gameDao.save(game);
    }

    @Override
    public Game getGame(UUID gameId) {
        return gameDao.findById(gameId).orElseThrow();
    }

    @Override
    public Game playMove(UUID gameId, String tokenName, int x, int y) throws InvalidPositionException {
        Game game = gameDao.findById(gameId).orElseThrow();
        game.getRemainingTokens().stream()
                .filter(t -> t.getName().equals(tokenName))
                .filter(Token::canMove)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Token not found"))
                .moveTo(new CellPosition(x, y));
        return game;
    }
}