package chess.service;

import chess.model.Cell;
import chess.model.Move;

/**
 * Service responsible for {@link Move} logics.
 */
public interface MoveService {
    /**
     * Builder method for {@link Move}.
     *
     * @param start start position {@link Cell}
     * @param end   end position {@link Cell}
     * @return built {@link Move}
     */
    Move buildMove(Cell start, Cell end);

    /**
     * Builder method for {@link Move} from coordinates.
     *
     * @param x1 start x position of Piece
     * @param y1 start y position of Piece
     * @param x2 end x position of Piece
     * @param y2 end position of Piece
     * @return built {@link Move}
     */
    Move buildMoveFromCoords(int x1, int y1, int x2, int y2);
}
