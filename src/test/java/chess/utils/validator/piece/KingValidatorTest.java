package chess.utils.validator.piece;

import chess.model.Board;
import chess.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KingValidatorTest {

    @Test
    void isKing_positive_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        int x = 0;
        int y = 3;

        //when
        boolean expected = KingValidator.isKing(board, x, y);

        //then
        Assertions.assertTrue(expected);
    }

    @Test
    void isKing_negative_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        int x = 1;
        int y = 3;

        //when
        boolean expected = KingValidator.isKing(board, x, y);

        //then
        Assertions.assertFalse(expected);
    }
}