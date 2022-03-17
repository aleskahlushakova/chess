package chess.utils.validator.piece;

import chess.enums.Color;
import chess.model.Board;
import chess.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PieceMoveValidatorTest {

    @Test
    void canPlacePiece_white_turn_positive_test() {
        //given
        int x2 = 7;
        int y2 = 3;

        //when
        boolean actual = PieceMoveValidator.canPlaceAttackingPiece(x2, y2);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void canPlacePiece_black_turn_positive_test() {
        //given
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);
        int x2 = 1;
        int y2 = 3;

        //when
        boolean actual = PieceMoveValidator.canPlaceAttackingPiece(x2, y2);
        game.setCurrentTurn(Color.WHITE);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void canPlacePiece_white_turn_negative_wrong_coordinates_test() {
        //given
        int x2 = 1;
        int y2 = 3;

        //when
        boolean actual = PieceMoveValidator.canPlaceAttackingPiece(x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void canPlacePiece_black_turn_negative_wrong_coordinates_test() {
        //given
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);
        int x2 = 7;
        int y2 = 3;

        //when
        boolean actual = PieceMoveValidator.canPlaceAttackingPiece(x2, y2);
        game.setCurrentTurn(Color.WHITE);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isPieceColorNotMatch_positive_test() {
        //given
        int i = 1; //white piece
        int j = 2;
        int x = 6; //black piece
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceColorNotMatch(i, j, x, y);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isPieceColorNotMatch_same_color_test() {
        //given
        int i = 1; //white piece
        int j = 2;
        int x = 0; //white piece
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceColorNotMatch(i, j, x, y);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isPieceColorNotMatch_empty_piece_test() {
        //given
        int i = 5; //empty piece
        int j = 2;
        int x = 0; //white piece
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceColorNotMatch(i, j, x, y);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void IsPieceBoardColorMatch_positive_test() {
        //given
        int x = 6;
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceTurnColorNotMatch(x, y);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void IsPieceBoardColorMatch_black_positive_test() {
        //given
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);
        int x = 1;
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceTurnColorNotMatch(x, y);
        game.setCurrentTurn(Color.WHITE);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void IsPieceBoardColorMatch_colors_match_test() {
        //given
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);
        int x = 6;
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceTurnColorNotMatch(x, y);
        game.setCurrentTurn(Color.WHITE);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void IsPieceBoardColorMatch_black_match_test() {
        //given
        int x = 1;
        int y = 2;

        //when
        boolean actual = PieceMoveValidator.isPieceTurnColorNotMatch(x, y);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void areCoordinatesInBound_positive_test() {
        //given
        int x1 = 0;
        int x2 = 2;
        int y1 = 6;
        int y2 = 7;

        //when
        boolean actual = PieceMoveValidator.areCoordinatesInBound(x1, y1, x2, y2);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void areCoordinatesInBound_x_out_of_bound_test() {
        //given
        int x1 = 0;
        int x2 = -2;
        int y1 = 6;
        int y2 = 7;

        //when
        boolean actual = PieceMoveValidator.areCoordinatesInBound(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void areCoordinatesInBound_y_out_of_bound_test() {
        //given
        int x1 = 0;
        int x2 = 2;
        int y1 = 600;
        int y2 = 7;

        //when
        boolean actual = PieceMoveValidator.areCoordinatesInBound(x1, y1, x2, y2);

        //then
        Assertions.assertFalse(actual);
    }
}