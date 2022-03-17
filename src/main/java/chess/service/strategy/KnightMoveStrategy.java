package chess.service.strategy;

import chess.enums.PieceType;
import chess.model.Move;
import chess.model.Piece;
import chess.service.PieceMoveService;

import static chess.utils.validator.piece.PieceMoveValidator.canPlaceAttackingPiece;

public class KnightMoveStrategy implements PieceMoveService {
    @Override
    public PieceType pieceTypeHandler() {
        return PieceType.KNIGHT;
    }

    @Override
    public boolean canBeMoved(final int x1, final int y1, final int x2, final int y2) {
        final int absX = Math.abs(x2 - x1);
        final int absY = Math.abs(y2 - y1);

        if (absX * absY == 2) {
            return canPlaceAttackingPiece(x2, y2);
        }

        return false;
    }

    @Override
    public boolean canBeMoved(final Piece piece, final Move move) {
        return false;
    }
}
