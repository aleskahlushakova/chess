package chess.service.impl;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Cell;
import chess.model.Game;
import chess.model.Piece;
import chess.service.BoardService;
import chess.service.CellService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Objects.isNull;

class BoardServiceImplTest {
    private final BoardService service = new BoardServiceImpl();
    private final CellService cellService = new CellServiceImpl();

    @Test
    void move_piece_by_coordinate_positive_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        Piece[][] pieces = board.getPieces();
        Piece piece = new Piece(Color.WHITE, PieceType.PAWN);
        int x1 = 0;
        int y1 = 1;
        int x2 = 1;
        int y2 = 2;

        //when
        service.movePieceOnBoard(piece, x1, y1, x2, y2);
        boolean actual = isNull(pieces[0][1]) && pieces[1][2] == piece;

        //then
        Assertions.assertTrue(actual);

    }


    @Test
    void move_piece_by_cell_positive_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        Piece[][] pieces = board.getPieces();
        Piece piece = new Piece(Color.WHITE, PieceType.PAWN);
        int x1 = 0;
        int y1 = 1;
        int x2 = 1;
        int y2 = 2;
        Cell start = cellService.buildCell(x1, y1);
        Cell end = cellService.buildCell(x2, y2);

        //when
        service.movePieceOnBoard(piece, start, end);
        boolean actual = isNull(pieces[0][1]) && pieces[1][2] == piece;

        //then
        Assertions.assertTrue(actual);

    }
}