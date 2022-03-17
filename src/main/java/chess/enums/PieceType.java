package chess.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum with possible {@link chess.model.Piece} types.
 * Values in constructor match unicode characters for the Piece.
 */
@RequiredArgsConstructor
@Getter
public enum PieceType {
    PAWN('\u2659', '\u265F', 10),
    QUEEN('\u2655', '\u265B', 200),
    KING('\u2654', '\u265A', 500),
    BISHOP('\u2657', '\u265D', 50),
    ROOK('\u2656', '\u265C', 100),
    KNIGHT('\u2658', '\u265E', 50);

    private final char whiteSymbol;
    private final char blackSymbol;
    private final int heuristicValue;

}
