package chess.service.strategy;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Game;
import chess.model.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BishopMoveStrategyTest {
    private final BishopMoveStrategy strategy = new BishopMoveStrategy();

    @Test
    void pieceTypeHandler() {
        //given
        PieceType expected = PieceType.BISHOP;

        //when
        PieceType actual = strategy.pieceTypeHandler();

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void canBeMoved_contradicting_logic_test() {
        //given
        int x1 = 0;
        int y1 = 2;
        int x2 = 1;
        int y2 = 2;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void canBeMoved_no_piece_on_the_way_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        Piece[][] pieces = board.getPieces();
        pieces[1][3] = null;
        int x1 = 0;
        int y1 = 2;
        int x2 = 1;
        int y2 = 3;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);
        pieces[1][3] = new Piece(Color.WHITE, PieceType.PAWN);

        //then
        Assertions.assertTrue(actual);
    }
}