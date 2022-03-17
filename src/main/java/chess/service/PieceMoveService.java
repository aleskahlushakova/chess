package chess.service;

import chess.enums.PieceType;
import chess.model.Move;
import chess.model.Piece;

/**
 * Service responsible for checking whether a {@link Piece} cam move logics.
 */
public interface PieceMoveService {
    /**
     * Handler method to determine which strategy class call.
     *
     * @return {@link PieceType} type of piece for which service to be invoked
     */
    PieceType pieceTypeHandler();

    /**
     * Checks if a {@link Piece} can be moved to specified {@link Move}.
     *
     * @param piece {@link Piece} to be moved
     * @param move  {@link Move} to be done
     * @return can be moved
     */
    boolean canBeMoved(Piece piece, Move move);

    /**
     * Checks if a {@link Piece} can be moved to specified coordinates.
     *
     * @param x1 start x position of Piece
     * @param y1 start y position of Piece
     * @param x2 end x position of Piece
     * @param y2 end y position of Piece
     * @return can be moved
     */
    boolean canBeMoved(int x1, int y1, int x2, int y2);

}
