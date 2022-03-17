package chess.service.strategy;

import chess.enums.PieceType;
import chess.model.Move;
import chess.model.Piece;
import chess.service.PieceMoveService;

public class QueenMoveStrategy implements PieceMoveService {
    private final RookMoveStrategy rookMoveStrategy = new RookMoveStrategy();
    private final BishopMoveStrategy bishopMoveStrategy = new BishopMoveStrategy();

    @Override
    public PieceType pieceTypeHandler() {
        return PieceType.QUEEN;
    }

    @Override
    public boolean canBeMoved(final int x1, final int y1, final int x2, final int y2) {
        final int absX = Math.abs(x2 - x1);
        final int absY = Math.abs(y2 - y1);

        if (absX == absY) {
            return bishopMoveStrategy.canBeMoved(x1, y1, x2, y2);

        } else if (absY == 0 || absX == 0) {
            return rookMoveStrategy.canBeMoved(x1, y1, x2, y2);
        }

        return false;
    }

    @Override
    public boolean canBeMoved(final Piece piece, final Move move) {
        return false;
    }
}
