package chess.contants;

/**
 * Program messages class.
 */
public interface MessageConstants {
    String INVALID_PIECE_MSG = "Invalid move: Not Your Piece.";
    String INVALID_POSITION_MSG = "Invalid move: Position Not valid! Try again.";
    String CHECKMATE_MSG = "Checkmate!";
    String CHECK_MSG = "Check!";
    String MOVED_MSG = "Piece moved.";
    String CANT_MOVE_MSG = "You are in check - can't move";
    String PLAY_MSG = " play.";
    String ENTER_START_SYMBOLIC_COORD_MSG = "Enter the start symbolic position (a-h): ";
    String ENTER_END_SYMBOLIC_COORD_MSG = "Enter the end symbolic position (a-h): ";
    String ENTER_START_NUMERIC_COORD_MSG = "Enter the start numeric position (1-8): ";
    String ENTER_END_NUMERIC_COORD_MSG = "Enter the end numeric position (1-8): ";
    String NOT_VALID_INPUT_MSG = "Symbolic coordinates should be a-h, numeric 1-8! Try again.";
}
