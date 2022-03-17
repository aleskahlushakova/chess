package chess.model;

import chess.enums.Color;
import chess.enums.PieceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Piece {
    private Color color;
    private PieceType pieceType;
}

