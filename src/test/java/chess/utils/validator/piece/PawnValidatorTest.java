package chess.utils.validator.piece;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PawnValidatorTest {

    @Test
    void isOneCellMove_simple_move_positive_test() {
        //given
        int absX = 1;
        int absY = 0;

        //when
        boolean actual = PawnValidator.isOneCellMove(absX, absY);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isOneCellMove_attack_move_positive_test() {
        //given
        int absX = 1;
        int absY = 1;

        //when
        boolean actual = PawnValidator.isOneCellMove(absX, absY);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isOneCellMove_attack_move_negative_test() {
        //given
        int absX = 2;
        int absY = 1;

        //when
        boolean actual = PawnValidator.isOneCellMove(absX, absY);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isTwoCellMove_white_positive_test() {
        //given
        Piece piece = null;
        int absX = 2;
        int x1 = 1;
        int y1 = 2;
        int y2 = 2;

        //when
        boolean actual = PawnValidator.isTwoCellMove(absX, x1, y1, y2, piece);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isTwoCellMove_black_positive_test() {
        //given
        Piece piece = null;
        int absX = 2;
        int x1 = 6;
        int y1 = 2;
        int y2 = 2;

        //when
        boolean actual = PawnValidator.isTwoCellMove(absX, x1, y1, y2, piece);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isTwoCellMove_negative_not_valid_start_x_test() {
        //given
        Piece piece = null;
        int absX = 2;
        //not valid start position
        int x1 = 3;
        int y1 = 2;
        int y2 = 2;

        //when
        boolean actual = PawnValidator.isTwoCellMove(absX, x1, y1, y2, piece);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isTwoCellMove_negative_piece_on_board_test() {
        //given
        Piece piece = new Piece(Color.WHITE, PieceType.PAWN);
        int absX = 2;
        //not valid start position
        int x1 = 6;
        int y1 = 2;
        int y2 = 2;

        //when
        boolean actual = PawnValidator.isTwoCellMove(absX, x1, y1, y2, piece);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isTwoCellMove_negative_y1_not_y2_test() {
        //given
        Piece piece = null;
        int absX = 2;
        int x1 = 6;
        //y1!=y2
        int y1 = 3;
        int y2 = 2;

        //when
        boolean actual = PawnValidator.isTwoCellMove(absX, x1, y1, y2, piece);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isMovedValid_is_moved_forward_positive_test() {
        //given
        int absY = 0;
        int x2 = 4;
        int y2 = 4;
        Piece piece = null;

        //when
        boolean actual = PawnValidator.isMovedValid(absY, x2, y2, piece);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isMovedValid_can_attack_negative_not_valid_coordinates_test() {
        //given
        int absY = 1;
        int x2 = 2;
        int y2 = 4;// kill bishop
        Piece piece = new Piece(Color.BLACK, PieceType.BISHOP);

        //when
        boolean actual = PawnValidator.isMovedValid(absY, x2, y2, piece);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isColorAndPositionMatch_positive_test() {
        //given
        int x1 = 1;
        int x2 = 2;
        Color color = Color.WHITE;

        //when
        boolean actual = PawnValidator.isColorAndPositionMatch(x2, x1, color);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isColorAndPositionMatch_black_positive_test() {
        //given
        int x1 = 7;
        int x2 = 6;
        Color color = Color.BLACK;

        //when
        boolean actual = PawnValidator.isColorAndPositionMatch(x2, x1, color);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isColorAndPositionMatch_black_backward_move_test() {
        //given
        int x1 = 6;
        int x2 = 7;
        Color color = Color.BLACK;

        //when
        boolean actual = PawnValidator.isColorAndPositionMatch(x2, x1, color);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isColorAndPositionMatch_white_backward_move_test() {
        //given
        int x1 = 7;
        int x2 = 6;
        Color color = Color.WHITE;

        //when
        boolean actual = PawnValidator.isColorAndPositionMatch(x2, x1, color);

        //then
        Assertions.assertFalse(actual);
    }
}