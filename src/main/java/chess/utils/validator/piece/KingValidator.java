package chess.utils.validator.piece;

import chess.model.Board;
import chess.model.Piece;

import static chess.enums.PieceType.KING;

/**
 * Validator class for KING {@link chess.enums.PieceType}.
 */
public class KingValidator {
    /**
     * Check if the {@link Piece} if of KING type.
     *
     * @param board {@link Board}
     * @param x     x coordinate of the Board
     * @param y     y coordinate of the Board
     * @return is KING type
     */
    public static boolean isKing(final Board board, final int x, final int y) {
        final Piece piece = board.getPieces()[x][y];
        return KING.equals(piece.getPieceType());
    }

    /**
     * Method checks KING move logics.
     *
     * @param absX x
     * @param absY x
     * @return is valid move
     */
    public static boolean isValidMove(final int absX, final int absY) {
        return (absX == 1 && absY == 0) || (absX == 0 && absY == 1) || (absX == 1 && absY == 1);
    }

}
