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
    PAWN('\u2659', '\u265F'),
    QUEEN('\u2655', '\u265B'),
    KING('\u2654', '\u265A'),
    BISHOP('\u2657', '\u265D'),
    ROOK('\u2656', '\u265C'),
    KNIGHT('\u2658', '\u265E');

    private final char whiteSymbol;
    private final char blackSymbol;

}
