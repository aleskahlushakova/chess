package chess.utils;

import chess.model.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static chess.contants.MessageConstants.ENTER_END_NUMERIC_COORD_MSG;
import static chess.contants.MessageConstants.ENTER_END_SYMBOLIC_COORD_MSG;
import static chess.contants.MessageConstants.ENTER_START_NUMERIC_COORD_MSG;
import static chess.contants.MessageConstants.ENTER_START_SYMBOLIC_COORD_MSG;
import static chess.contants.MessageConstants.NOT_VALID_INPUT_MSG;
import static chess.contants.MessageConstants.PLAY_MSG;
import static chess.utils.validator.InputValidator.validateInput;

/**
 * Utility class that prints user dialogs.
 */
public class DialogPrinter {
    /**
     * User dialog method.
     * Asks for input of start and end positions.
     * Validates input.
     *
     * @return List of retrieved coordinates
     */
    public static List<String> retrieveCoords() {
        final Game game = Game.getInstance();
        final List<String> coords = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        System.out.println(game.getCurrentTurn() + PLAY_MSG);
        System.out.println(ENTER_START_SYMBOLIC_COORD_MSG);
        coords.add(input.nextLine());
        System.out.println(ENTER_START_NUMERIC_COORD_MSG);
        coords.add(input.nextLine());
        System.out.println(ENTER_END_SYMBOLIC_COORD_MSG);
        coords.add(input.nextLine());
        System.out.println(ENTER_END_NUMERIC_COORD_MSG);
        coords.add(input.nextLine());

        if (!validateInput(coords)) {
            System.out.println(NOT_VALID_INPUT_MSG);
            return retrieveCoords();
        }

        return coords;
    }
}
