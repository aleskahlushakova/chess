package chess.utils.validator.piece;

/**
 * Validator class for ROOK {@link chess.enums.PieceType}.
 */
public class RookValidator {
    /**
     * Methpd to check if ROOK move formula corresponds.
     *
     * @param absX abs of x coordinates
     * @param absY abs of y coordinates
     * @return is formula valid
     */
    public static boolean isValidMoveFormula(final int absX, final int absY) {
        return (absX == 0 && absY != 0) || (absX != 0 && absY == 0);
    }
}
