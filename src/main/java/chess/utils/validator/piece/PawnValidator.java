package chess.utils.validator.piece;

import chess.enums.Color;
import chess.model.Piece;

import static chess.enums.Color.BLACK;
import static chess.enums.Color.WHITE;
import static chess.utils.validator.piece.PieceMoveValidator.canPlaceAttackingPiece;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Validator class for PAWN {@link chess.enums.PieceType}.
 * Checks Piece move logics.
 */
public class PawnValidator {
    /**
     * Method checks if pawn moved in 1 cell.
     *
     * @param absX abs x
     * @param absY abs y
     * @return is moved in 1 cell
     */
    public static boolean isOneCellMove(final int absX, final int absY) {
        return (absX == 1 && absY == 0) || (absX == 1 && absY == 1);
    }

    /**
     * Method checks if pawn moved in 2 cells.
     *
     * @param absX  abs x
     * @param x1    start x position
     * @param y1    start y position
     * @param y2    end y position
     * @param piece {@link Piece} to be moved
     * @return is moved in 2 cells
     */
    public static boolean isTwoCellMove(final int absX, final int x1, final int y1, final int y2, final Piece piece) {
        return (absX == 2) && (y2 == y1) && isNull(piece) && (x1 == 6 || x1 == 1);
    }

    /**
     * Method checks the validity of Pawn move.
     *
     * @param absY  abs x
     * @param x2    end x position
     * @param y2    end y position
     * @param piece {@link Piece}
     * @return is valid
     */
    public static boolean isMovedValid(final int absY, final int x2, final int y2, final Piece piece) {
        return isMovedForward(absY, piece) || isAttackedAndPlaced(absY, x2, y2, piece);
    }

    /**
     * Method checks the direction of the pawn.
     *
     * @param x2    end x position
     * @param x1    start x position
     * @param color {@link Color} of {@link Piece}
     * @return is valid
     */
    public static boolean isColorAndPositionMatch(final int x2, final int x1, final Color color) {
        return isValidWhiteMove(x2, x1, color) || isValidBlackMove(x2, x1, color);
    }

    private static boolean isMovedForward(final int absY, final Piece piece) {
        return isNull(piece) && absY == 0;
    }

    private static boolean isAttackedAndPlaced(final int absY, final int x2, final int y2, final Piece piece) {
        return absY == 1 && nonNull(piece) && canPlaceAttackingPiece(x2, y2);
    }


    private static boolean isValidWhiteMove(final int x2, final int x1, final Color color) {
        return (WHITE.equals(color) && x2 > x1);
    }

    private static boolean isValidBlackMove(final int x2, final int x1, final Color color) {
        return (BLACK.equals(color) && x2 < x1);
    }

}
