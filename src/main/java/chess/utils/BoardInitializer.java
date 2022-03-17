package chess.utils;

import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Piece;

import static chess.contants.BoardConstants.BOARD_WIDTH;

/**
 * Utility class to initialize {@link Board}.
 */
public class BoardInitializer {
    /**
     * Method initializes {@link Board}. Board is represented as 2d array.
     *
     * @return {@link Board}
     */
    public static Board initBoard() {
        final Board board = new Board();
        final Piece[][] pieces = board.getPieces();

        whitePiecesInit(pieces);
        blackPiecesInit(pieces);

        return board;
    }

    /**
     * Initialize White Pieces.
     *
     * @param pieces Board pieces
     */
    private static void whitePiecesInit(final Piece[][] pieces) {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            pieces[1][i] = new Piece(Color.WHITE, PieceType.PAWN);
        }

        for (int i = 0; i <= 7; i += 7) {
            pieces[0][i] = new Piece(Color.WHITE, PieceType.ROOK);
        }

        for (int i = 1; i <= 6; i += 5) {
            pieces[0][i] = new Piece(Color.WHITE, PieceType.KNIGHT);
        }

        for (int i = 2; i <= 5; i++) {
            pieces[0][i] = new Piece(Color.WHITE, PieceType.BISHOP);
        }

        pieces[0][3] = new Piece(Color.WHITE, PieceType.KING);
        pieces[0][4] = new Piece(Color.WHITE, PieceType.QUEEN);
    }

    /**
     * Initialize Black Pieces.
     *
     * @param pieces Board pieces
     */
    private static void blackPiecesInit(final Piece[][] pieces) {

        for (int i = 0; i < BOARD_WIDTH; i++) {
            pieces[6][i] = new Piece(Color.BLACK, PieceType.PAWN);
        }

        for (int i = 0; i <= 7; i += 7) {
            pieces[7][i] = new Piece(Color.BLACK, PieceType.ROOK); //Rook initialization
        }

        for (int i = 1; i <= 6; i += 5) {
            pieces[7][i] = new Piece(Color.BLACK, PieceType.KNIGHT);//black knight initialization
        }

        for (int i = 2; i <= 5; i++) {
            pieces[7][i] = new Piece(Color.BLACK, PieceType.BISHOP); //black bishop initialization
        }

        pieces[7][4] = new Piece(Color.BLACK, PieceType.QUEEN);
        pieces[7][3] = new Piece(Color.BLACK, PieceType.KING);
    }
}
