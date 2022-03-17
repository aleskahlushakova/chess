package chess.service.impl;

import chess.model.Cell;
import chess.service.CellService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellServiceImplTest {
    private final CellService service = new CellServiceImpl();

    @Test
    void buildCell_equal_test() {
        //given
        int x = 0;
        int y = 0;
        Cell expected = Cell.builder()
                .x(x)
                .y(y)
                .build();
        //when
        Cell actual = service.buildCell(x, y);

        //then
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void buildCell_not_equal() {
        //given
        int x = 0;
        int y = 0;
        Cell expected = Cell.builder()
                .x(1)
                .y(y)
                .build();
        //when
        Cell actual = service.buildCell(x, y);

        //then
        Assertions.assertNotEquals(actual, expected);
    }
}