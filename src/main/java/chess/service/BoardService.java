package chess.service;

import chess.model.Cell;
import chess.model.Piece;

/**
 * Service responsible for {@link chess.model.Board} logics.
 */
public interface BoardService {
    /**
     * Sets {@link Piece} from start position to end position coordinates or vice versa.
     *
     * @param piece {@link Piece} to be moved
     * @param x1    start x position
     * @param y1    start y position
     * @param x2    end x position
     * @param y2    end y position
     */
    void movePieceOnBoard(Piece piece, int x1, int y1, int x2, int y2);

    /**
     * Sets {@link Piece} from start position to end position or vice versa.
     *
     * @param piece {@link Piece} to be moved
     * @param start  {@link Cell} to be done
     * @param end {@link Cell} to be done
     */
    void movePieceOnBoard(Piece piece, Cell start, Cell end);
}
