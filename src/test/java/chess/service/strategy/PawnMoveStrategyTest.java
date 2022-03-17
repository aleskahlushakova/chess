package chess.service.strategy;

import chess.enums.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnMoveStrategyTest {

    private final PawnMoveStrategy strategy = new PawnMoveStrategy();

    @Test
    void pieceTypeHandler() {
        //given
        PieceType expected = PieceType.PAWN;

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
        int x2 = 6;
        int y2 = 2;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void testCanBeMoved_two_cell_forward_logic_test() {
        //given
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 2;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void canBeMoved_diagonally_test() {
        //given
        int x1 = 1;
        int y1 = 2;
        int x2 = 2;
        int y2 = 3;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void canBeMoved_backwards_logic_test() {
        //given
        int x1 = 2;
        int y1 = 2;
        int x2 = 1;
        int y2 = 2;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }
}