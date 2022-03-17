package chess.service.impl;

import chess.model.Move;
import chess.model.Cell;
import chess.service.MoveService;
import chess.service.CellService;

public class MoveServiceImpl implements MoveService {
    private final CellService cellService = new CellServiceImpl();

    @Override
    public Move buildMove(final Cell start, final Cell end) {
        return Move.builder()
                .start(start)
                .end(end)
                .build();
    }

    @Override
    public Move buildMoveFromCoords(final int x1, final int y1, final int x2, final int y2) {
        final Cell start = cellService.buildCell(x1, y1);
        final Cell end = cellService.buildCell(x2, y2);

        return buildMove(start, end);
    }

}
