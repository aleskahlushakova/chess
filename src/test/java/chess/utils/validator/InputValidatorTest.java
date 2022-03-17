package chess.utils.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class InputValidatorTest {

    @Test
    void validateInput_positive_test() {
        //given
        List<String> input = Arrays.asList("e", "2", "e", "4");
        //when
        boolean actual = InputValidator.validateInput(input);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void validateInput_negative_empty_string_test() {
        //given
        List<String> input = Arrays.asList("", "", "e", "4r");
        //when
        boolean actual = InputValidator.validateInput(input);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void validateInput_negative_mixed_coords_test() {
        //given
        List<String> input = Arrays.asList("2", "e", "4", "e");
        //when
        boolean actual = InputValidator.validateInput(input);
        //then
        Assertions.assertFalse(actual);
    }
}