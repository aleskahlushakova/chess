package chess.service.impl;

import chess.model.Cell;
import chess.model.Move;
import chess.service.CellService;
import chess.service.MoveService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveServiceImplTest {

    private final MoveService service = new MoveServiceImpl();
    private final CellService cellService = new CellServiceImpl();

    @Test
    void buildMove_equal_test() {
        //given
        int x1 = 0;
        int y1 = 0;
        int x2 = 1;
        int y2 = 1;
        Move expected = Move.builder()
                .start(cellService.buildCell(x1, y1))
                .end(cellService.buildCell(x2, y2))
                .build();
        //when
        Move actual = service.buildMoveFromCoords(x1, y1, x2, y2);

        //then
        Assertions.assertEquals(actual, expected);
    }


    @Test
    void buildMove_not_equal_test() {
        //given
        int x1 = 0;
        int y1 = 0;
        int x2 = 1;
        int y2 = 1;
        Move expected = Move.builder()
                .start(cellService.buildCell(3, y1))
                .end(cellService.buildCell(x2, y2))
                .build();
        //when
        Move actual = service.buildMoveFromCoords(x1, y1, x2, y2);

        //then
        Assertions.assertNotEquals(actual, expected);
    }

    @Test
    void buildMoveFromCoords_equal_test() {
        //given
        int x1 = 0;
        int y1 = 0;
        int x2 = 1;
        int y2 = 1;
        Cell start = cellService.buildCell(x1, y1);
        Cell end = cellService.buildCell(x2, y2);
        Move expected = Move.builder()
                .start(start)
                .end(end)
                .build();
        //when
        Move actual = service.buildMove(start, end);

        //then
        Assertions.assertEquals(actual, expected);
    }
}