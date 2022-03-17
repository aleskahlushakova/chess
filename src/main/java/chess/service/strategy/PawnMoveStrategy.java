package chess.service.strategy;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Game;
import chess.model.Move;
import chess.model.Piece;
import chess.service.PieceMoveService;

import static chess.utils.validator.piece.PawnValidator.isColorAndPositionMatch;
import static chess.utils.validator.piece.PawnValidator.isMovedValid;
import static chess.utils.validator.piece.PawnValidator.isOneCellMove;
import static chess.utils.validator.piece.PawnValidator.isTwoCellMove;

public class PawnMoveStrategy implements PieceMoveService {
    @Override
    public PieceType pieceTypeHandler() {
        return PieceType.PAWN;
    }

    @Override
    public boolean canBeMoved(final int x1, final int y1, final int x2, final int y2) {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        final Piece endMovePiece = board.getPieces()[x2][y2];
        final Color turn = game.getCurrentTurn();
        final int absX = Math.abs(x2 - x1);
        final int absY = Math.abs(y2 - y1);

        if (isOneCellMove(absX, absY)) {
            if (isMovedValid(absY, x2, y2, endMovePiece)) {
                return isColorAndPositionMatch(x2, x1, turn);
            }
        } else return isTwoCellMove(absX, x1, y1, y2, endMovePiece);

        return false;
    }

    @Override
    public boolean canBeMoved(Piece piece, Move move) {
        return false;
    }
}
