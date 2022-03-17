package chess.service.strategy;

import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Game;
import chess.model.Move;
import chess.model.Piece;
import chess.service.PieceMoveService;

import static chess.utils.validator.piece.PieceMoveValidator.canPlaceAttackingPiece;
import static java.util.Objects.isNull;

public class BishopMoveStrategy implements PieceMoveService {
    @Override
    public PieceType pieceTypeHandler() {
        return PieceType.BISHOP;
    }

    @Override
    public boolean canBeMoved(final int x1, final int y1, final int x2, final int y2) {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        final Piece[][] pieces = board.getPieces();
        final Piece endMovePiece = pieces[x2][y2];

        final int absX = Math.abs(x2 - x1);
        final int absY = Math.abs(y2 - y1);

        if (absX == absY) {
            final int count = makeMovesByStep(pieces, x1, y1, x2, y2, absX);
            if (isNull(endMovePiece) && count == absX + 1) {
                return true;
            } else return count == absX - 1 && canPlaceAttackingPiece(x2, y2);
        }

        return false;
    }

    @Override
    public boolean canBeMoved(final Piece piece, final Move move) {
        return false;
    }

    private int makeMovesByStep(final Piece[][] pieces,
                                final int x1,
                                final int y1,
                                final int x2,
                                final int y2,
                                final int absX) {
        int count = 1;
        while (count <= absX) {
            int row, col;
            if (x2 < x1 && y2 < y1) {        // upper left direction
                row = x1 - count;
                col = y1 - count;
            } else if (x2 < x1 && y2 > y1) {        // upper right direction
                row = x1 - count;
                col = y1 + count;
            } else if (x2 > x1 && y2 < y1) {        // lower left direction
                row = x1 + count;
                col = y1 - count;
            } else {                        // lower right direction
                row = x1 + count;
                col = y1 + count;
            }
            if (isNull(pieces[row][col])) {
                count++;
            } else {
                count--;
                break;
            }
        }
        return count;
    }
}
