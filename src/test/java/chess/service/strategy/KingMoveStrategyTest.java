package chess.service.strategy;

import chess.enums.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingMoveStrategyTest {

    private final KingMoveStrategy strategy = new KingMoveStrategy();

    @Test
    void pieceTypeHandler() {
        //given
        PieceType expected = PieceType.KING;

        //when
        PieceType actual = strategy.pieceTypeHandler();

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void canBeMoved_one_piece_test() {
        //given
        int x1 = 1;
        int y1 = 1;
        int x2 = 2;
        int y2 = 1;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void canBeMoved_two_piece_test() {
        //given
        int x1 = 1;
        int y1 = 1;
        int x2 = 3;
        int y2 = 1;

        //when
        boolean actual = strategy.canBeMoved(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }
}