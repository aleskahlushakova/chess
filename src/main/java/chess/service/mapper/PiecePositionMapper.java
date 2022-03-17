package chess.service.mapper;

import static chess.contants.BoardConstants.SYMBOLIC_COORDS;

/**
 * Mapper class to match human-readable coords with dynamic array positions.
 */
public class PiecePositionMapper {
    /**
     * Maps symbols from [a-h] to [0-7].
     *
     * @param symbol String with values from a to h
     * @return x position of the {@link chess.model.Board} array
     */
    public int mapSymbolic(final String symbol) {
        return SYMBOLIC_COORDS.get(symbol);
    }

    /**
     * Maps numbers from [1-8] to [0-7]
     * @param number String with values from 1 to 8
     * @return y position of the {@link chess.model.Board} array
     */
    public int mapNumeric(final String number) {
        return Integer.parseInt(number) - 1;
    }
}
