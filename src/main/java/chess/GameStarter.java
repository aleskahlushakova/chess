package chess;

import chess.service.GameService;
import chess.service.impl.GameServiceImpl;

public class GameStarter {
    /**
     * Entry point method.
     *
     * @param arg command line args
     */
    public static void main(String[] arg) {
        final GameService gameService = new GameServiceImpl();
        gameService.startGame();
    }

}
