package chess.utils.validator;

import java.util.List;
import java.util.regex.Pattern;

import static chess.contants.BoardConstants.NUMERIC_PATTERN;
import static chess.contants.BoardConstants.SYMBOLIC_PATTERN;

/**
 * Utility class that validate User input.
 */
public class InputValidator {
    /**
     * Method checks if retrieved coordinates are correct.
     *
     * @param inputs List of inputted coordinates
     * @return is valid
     */
    public static boolean validateInput(final List<String> inputs) {
        boolean isValid = false;
        for (int i = 0; i < inputs.size() / 2; i += 2) {
            isValid = validateSymbolicPosition(inputs.get(i)) && validateNumericPosition(inputs.get(i + 1));
        }
        return isValid;
    }

    /**
     * Method checks if x input coordinate matches pattern.
     *
     * @param input input String
     * @return is valid
     */
    private static boolean validateSymbolicPosition(final String input) {
        return Pattern.matches(SYMBOLIC_PATTERN, input);
    }

    /**
     * Method checks if y input coordinate matches pattern.
     *
     * @param input input String
     * @return is valid
     */
    private static boolean validateNumericPosition(final String input) {
        return Pattern.matches(NUMERIC_PATTERN, input);
    }
}
