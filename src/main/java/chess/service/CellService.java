package chess.service;

import chess.model.Cell;

/**
 * Service responsible for {@link Cell} logics.
 */
public interface CellService {
    /**
     * Builder method to create {@link Cell}.
     *
     * @param x x position of the {@link chess.model.Board} array
     * @param y y position of the {@link chess.model.Board} array
     * @return new {@link Cell}
     */
    Cell buildCell(int x, int y);
}
