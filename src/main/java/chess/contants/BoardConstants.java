package chess.contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Program constants class.
 */
public interface BoardConstants {
    int BOARD_WIDTH = 8;
    int BOARD_HEIGHT = 8;
    char EM_WHITESPACE = '\u2001';
    String WHITESPACE = " ";
    String SYMBOLIC_PATTERN = "^[a-h]{1}";
    String NUMERIC_PATTERN = "^[1-8]{1}";
    String BOARD_KEYS = " \u2001  h \u2001g \u2001f \u2001e \u2001d \u2001c \u2001b \u2001a";
    Map<String, Integer> SYMBOLIC_COORDS = new HashMap<>() {{
        put("h", 0);
        put("g", 1);
        put("f", 2);
        put("e", 3);
        put("d", 4);
        put("c", 5);
        put("b", 6);
        put("a", 7);
    }};
}
