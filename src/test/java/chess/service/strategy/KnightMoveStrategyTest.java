package chess.service.strategy;

import chess.enums.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightMoveStrategyTest {

    private final  KnightMoveStrategy strategy = new KnightMoveStrategy();
    @Test
    void pieceTypeHandler() {
        //given
        PieceType expected = PieceType.KNIGHT;

        //when
        PieceType actual = strategy.pieceTypeHandler();

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void canBeMoved_contradicting_logic_test() {
        //given
        int x1 = 0;
        int y1 = 6;
        int x2 = 1;
        int y2 = 2;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void canBeMoved_right_logic_test() {
        //given
        int x1 = 0;
        int y1 = 6;
        int x2 = 2;
        int y2 = 5;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void canBeMoved_right_logic_to_corner_test() {
        //given
        int x1 = 0;
        int y1 = 6;
        int x2 = 2;
        int y2 = 7;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertTrue(actual);
    }
}