package chess.service.impl;

import chess.model.Cell;
import chess.service.CellService;

public class CellServiceImpl implements CellService {
    @Override
    public Cell buildCell(final int x, final int y) {
        return Cell.builder()
                .x(x)
                .y(y)
                .build();
    }
}
