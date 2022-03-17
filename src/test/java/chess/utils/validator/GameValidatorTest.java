package chess.utils.validator;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Game;
import chess.model.Piece;
import chess.service.BoardService;
import chess.service.impl.BoardServiceImpl;
import chess.utils.BoardInitializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameValidatorTest {

    @Test
    void isCheckmate_initial_test() {
        //given
        Game game = Game.getInstance();
        Board board = game.getBoard();
        board.setPieces(BoardInitializer.initBoard().getPieces());
        //when
        boolean actual = GameValidator.isCheckmate();

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isCheckmate_checkmate_test() {
        //given
        BoardService service = new BoardServiceImpl();
        //children mate in 3 moves
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.PAWN),1, 3, 3, 3);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.PAWN),6, 3, 4, 3);
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.BISHOP),0, 2, 3, 5);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.PAWN),6, 7, 5, 7);
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.QUEEN),0, 4, 4, 0);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.KING),7, 6, 5, 7);
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.KING),4, 0, 5, 2);

        //when
        boolean actual = GameValidator.isCheckmate();

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isChecked_not_check_test() {
        //given
        BoardService service = new BoardServiceImpl();
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.PAWN),1, 4, 3, 4);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.PAWN),6, 3, 4, 3);
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);

        //when
        boolean actual = GameValidator.isChecked();
        game.setCurrentTurn(Color.WHITE);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void isChecked_check_test() {
        //given
        BoardService service = new BoardServiceImpl();
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.PAWN),1, 4, 3, 4);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.PAWN),6, 3, 4, 3);
        service.movePieceOnBoard(new Piece(Color.WHITE, PieceType.BISHOP),0, 5, 2, 3);
        service.movePieceOnBoard(new Piece(Color.BLACK, PieceType.BISHOP),7, 2, 3, 6);
        Game game = Game.getInstance();
        game.setCurrentTurn(Color.BLACK);

        //when
        boolean actual = GameValidator.isChecked();
        game.setCurrentTurn(Color.WHITE);

        //then
        Assertions.assertTrue(actual);
    }
}