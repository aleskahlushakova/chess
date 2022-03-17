package chess.service.impl;

import chess.model.Board;
import chess.model.Cell;
import chess.model.Game;
import chess.model.Piece;
import chess.service.BoardService;
import chess.service.CellService;

public class BoardServiceImpl implements BoardService {
    private final CellService cellService = new CellServiceImpl();

    @Override
    public void movePieceOnBoard(final Piece piece, final int x1, final int y1, final int x2, final int y2) {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        final Cell start = cellService.buildCell(x1, y1);
        final Cell end = cellService.buildCell(x2, y2);

        board.setPiece(start, null);
        board.setPiece(end, piece);
    }

    @Override
    public void movePieceOnBoard(final Piece piece, final Cell start, final Cell end) {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();

        board.setPiece(start, null);
        board.setPiece(end, piece);
    }
}
