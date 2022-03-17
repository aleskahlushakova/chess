package chess.utils.validator;

import chess.model.Board;
import chess.model.Cell;
import chess.model.Game;
import chess.model.Move;
import chess.model.Piece;
import chess.service.BoardService;
import chess.service.GameService;
import chess.service.MoveService;
import chess.service.PieceMoveService;
import chess.service.impl.BoardServiceImpl;
import chess.service.impl.GameServiceImpl;
import chess.service.impl.MoveServiceImpl;
import chess.service.impl.PieceMoveServiceImpl;
import chess.service.strategy.BishopMoveStrategy;
import chess.service.strategy.KingMoveStrategy;
import chess.service.strategy.KnightMoveStrategy;
import chess.service.strategy.PawnMoveStrategy;
import chess.service.strategy.QueenMoveStrategy;
import chess.service.strategy.RookMoveStrategy;
import chess.utils.validator.piece.PieceMoveValidator;

import java.util.List;

import static chess.contants.BoardConstants.BOARD_HEIGHT;
import static chess.contants.BoardConstants.BOARD_WIDTH;
import static chess.utils.validator.piece.KingValidator.isKing;
import static chess.utils.validator.piece.PieceMoveValidator.canPieceAttack;
import static chess.utils.validator.piece.PieceMoveValidator.isPieceTurnColorNotMatch;
import static java.util.Objects.nonNull;

/**
 * Utility class to validate chess game rules.
 */
public class GameValidator {
    private final static List<PieceMoveService> strategies = List.of(new BishopMoveStrategy(),
            new KingMoveStrategy(),
            new KnightMoveStrategy(),
            new PawnMoveStrategy(),
            new QueenMoveStrategy(),
            new RookMoveStrategy());
    private final static PieceMoveService pieceMoveService = new PieceMoveServiceImpl(strategies);
    private final static GameService gameService = new GameServiceImpl();
    private final static Game game = Game.getInstance();
    private final static Board board = game.getBoard();
    private final static BoardService boardService = new BoardServiceImpl();
    private final static MoveService moveService = new MoveServiceImpl();

    /**
     * Checks for checkmate.
     *
     * @return is checkmate
     */
    public static boolean isCheckmate() {
        boolean canEscapeCheckmate = false;

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                final Piece piece = board.getPieces()[i][j];
                if (nonNull(piece)) {
                    canEscapeCheckmate = canEscapeCheckmate(piece, i, j);
                }
            }
        }
        return !canEscapeCheckmate;
    }

    /**
     * Method checks if there is Check on the {@link Board}.
     *
     * @return is checked
     */
    public static boolean isChecked() {
        boolean isChecked = false;
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        int x = 0, y = 0;
        // loop for getting king's location
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (isPieceTurnColorNotMatch(i, j) && isKing(board, i, j)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        //loop for checking opposite can attack or not
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (PieceMoveValidator.isPieceColorNotMatch(i, j, x, y) && canPieceAttack(board, i, j, x, y)) {
                    isChecked = true;
                }
            }
        }
        return isChecked;
    }

    /**
     * Method checks if checkmate can be prevented.
     *
     * @param piece {@link Piece} to prevent checkmate
     * @param i     x position
     * @param j     y position
     * @return can checkmate be prevented
     */
    private static boolean canEscapeCheckmate(final Piece piece, final int i, final int j) {
        boolean isCheckmateAvoidable = false;
        for (int k = 0; k < BOARD_WIDTH; k++) {
            for (int m = 0; m < BOARD_HEIGHT; m++) {
                gameService.changeTurn();

                boolean canBeMoved = false;
                if (game.getCurrentTurn().equals(piece.getColor())) {
                    final Move move = moveService.buildMoveFromCoords(i, j, k, m);
                    canBeMoved = pieceMoveService.canBeMoved(piece, move);
                }

                if (canBeMoved) {
                    boardService.movePieceOnBoard(piece, i, j, k, m);
                    gameService.changeTurn();
                    if (!isChecked()) {
                        isCheckmateAvoidable = true;
                    }
                    boardService.movePieceOnBoard(piece, k, m, i, j);
                } else {
                    gameService.changeTurn();
                }
            }
        }
        return !isCheckmateAvoidable;
    }

}
