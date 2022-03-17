package chess.utils;

import chess.contants.BoardConstants;
import chess.enums.Color;
import chess.enums.PieceType;
import chess.model.Board;
import chess.model.Game;
import chess.model.Piece;

import static chess.contants.BoardConstants.BOARD_HEIGHT;
import static chess.contants.BoardConstants.BOARD_KEYS;
import static chess.contants.BoardConstants.BOARD_WIDTH;
import static chess.contants.BoardConstants.WHITESPACE;
import static java.util.Objects.nonNull;

/**
 * Utility class that is responsible for printing chess board.
 */
public class BoardPrinter {
    /**
     * Method prints chess board.
     */
    public static void showBoard() {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        final Piece[][] pieces = board.getPieces();
        for (int i = 0; i < BOARD_WIDTH; i++) {
            System.out.print(WHITESPACE + (i + 1) + WHITESPACE);
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                char piece = nonNull(pieces[i][j]) ? getPieceSymbol(pieces[i][j]) : BoardConstants.EM_WHITESPACE;
                System.out.print(WHITESPACE + piece + WHITESPACE);
            }
            System.out.println();
        }
        System.out.println(BOARD_KEYS);
    }

    /**
     * Gets symbol depending on {@link PieceType} and {@link Color}.
     *
     * @param piece {@link Piece} to be examined
     * @return whitespace of chess unicode symbol
     */
    private static char getPieceSymbol(final Piece piece) {
        final boolean isWhite = piece.getColor().equals(Color.WHITE);
        PieceType pieceType = piece.getPieceType();
        return isWhite ? pieceType.getBlackSymbol() : pieceType.getWhiteSymbol();
    }
}
