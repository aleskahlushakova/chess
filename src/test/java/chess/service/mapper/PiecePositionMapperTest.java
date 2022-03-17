package chess.service.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PiecePositionMapperTest {
    private final PiecePositionMapper mapper = new PiecePositionMapper();

    @Test
    void mapSymbolic_positive_test() {
        //given
        final String aPosition = "a";
        final int expected = 7;
        //when
        final int actual = mapper.mapSymbolic(aPosition);
        //then
        assertEquals(actual, expected);
    }

    @Test
    void mapNumeric_positive_test() {
        //given
        final String numeric = "1";
        final int expected = 0;
        //when
        final int actual = mapper.mapNumeric(numeric);
        //then
        assertEquals(actual, expected);
    }
}