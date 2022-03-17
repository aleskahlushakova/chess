package chess.utils.validator.piece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookValidatorTest {

    @Test
    void isValidMoveFormula_vertical_move_positive_test() {
        //given
        int absX = 3;
        int absY = 0;

        //when
        boolean actual = RookValidator.isValidMoveFormula(absX, absY);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isValidMoveFormula_horizontal_move_positive_test() {
        //given
        int absX = 0;
        int absY = 3;

        //when
        boolean actual = RookValidator.isValidMoveFormula(absX, absY);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isValidMoveFormula_negative_test() {
        //given
        int absX = 3;
        int absY = 3;

        //when
        boolean actual = RookValidator.isValidMoveFormula(absX, absY);

        //then
        Assertions.assertFalse(actual);
    }
}