package chess.utils.validator.piece;

import chess.enums.Color;
import chess.model.Board;
import chess.model.Game;
import chess.model.Move;
import chess.model.Piece;
import chess.service.MoveService;
import chess.service.PieceMoveService;
import chess.service.impl.MoveServiceImpl;
import chess.service.impl.PieceMoveServiceImpl;
import chess.service.strategy.BishopMoveStrategy;
import chess.service.strategy.KingMoveStrategy;
import chess.service.strategy.KnightMoveStrategy;
import chess.service.strategy.PawnMoveStrategy;
import chess.service.strategy.QueenMoveStrategy;
import chess.service.strategy.RookMoveStrategy;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Validator common class for {@link chess.enums.PieceType}.
 */
public class PieceMoveValidator {
    final static List<PieceMoveService> strategies = List.of(new BishopMoveStrategy(),
            new KingMoveStrategy(),
            new KnightMoveStrategy(),
            new PawnMoveStrategy(),
            new QueenMoveStrategy(),
            new RookMoveStrategy());
    private static final Game game = Game.getInstance();
    private static final Board board = game.getBoard();
    private final static PieceMoveService pieceMoveService = new PieceMoveServiceImpl(strategies);
    private final static MoveService moveService = new MoveServiceImpl();

    /**
     * Method checks if {@link Piece} can be put.
     *
     * @param x2 end move x coordinate
     * @param y2 end move y coordinate
     * @return can {@link Piece} be put
     */
    public static boolean canPlaceAttackingPiece(final int x2, final int y2) {
        final Piece[][] pieces = board.getPieces();
        final Piece endMovePiece = pieces[x2][y2];
        final Color currentColor = game.getCurrentTurn();

        if (nonNull(endMovePiece)) {
            return !endMovePiece.getColor().equals(currentColor);
        }

        return true;
    }

    /**
     * Method checks if two {@link Piece} color match.
     *
     * @param i start x position of the {@link Board} array
     * @param j start y position of the {@link Board} array
     * @param x end x position of the {@link Board} array
     * @param y end y position of the {@link Board} array
     * @return colors match
     */
    public static boolean isPieceColorNotMatch(final int i, final int j, final int x, final int y) {
        final Piece king = board.getPieces()[x][y];
        final Piece piece = board.getPieces()[i][j];
        return nonNull(piece) && !king.getColor().equals(piece.getColor());
    }

    /**
     * Method checks if {@link Piece} color match current turn.
     *
     * @param x start x position of the {@link Board} array
     * @param y start y position of the {@link Board} array
     * @return colors match
     */
    public static boolean isPieceTurnColorNotMatch(final int x, final int y) {
        final Piece piece = board.getPieces()[x][y];
        return nonNull(piece) && !game.getCurrentTurn().equals(piece.getColor());
    }

    /**
     * Method checks if {@link Piece} can attack.
     *
     * @param board {@link Board}
     * @param i     start x position of the {@link Board} array
     * @param j     start y position of the {@link Board} array
     * @param x     end x position of the {@link Board} array
     * @param y     end y position of the {@link Board} array
     * @return can attack
     */
    public static boolean canPieceAttack(final Board board, final int i, final int j, final int x, final int y) {
        final Piece piece = board.getPieces()[i][j];
        final Move move = moveService.buildMoveFromCoords(i, j, x, y);
        return pieceMoveService.canBeMoved(piece, move);
    }

    /**
     * Method checks if coordinates are on bound of 0-7
     *
     * @param x1 start x position of the {@link Board} array
     * @param y1 start y position of the {@link Board} array
     * @param x2 end x position of the {@link Board} array
     * @param y2 end y position of the {@link Board} array
     * @return are in bound
     */
    public static boolean areCoordinatesInBound(final int x1, final int y1, final int x2, final int y2) {
        return isCoordinateInBound(x1)
                && isCoordinateInBound(y1)
                && isCoordinateInBound(x2)
                && isCoordinateInBound(y2);
    }

    private static boolean isCoordinateInBound(final int coordinate) {
        return coordinate < 8 && coordinate >= 0;
    }
}
