package chess.model;

import chess.enums.Color;
import chess.utils.BoardInitializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Game {
    private static final Object mutex = new Object();
    private static Game instance;

    private volatile Player whitePlayer;
    private volatile Player blackPlayer;
    private volatile Board board;
    private volatile Color currentTurn;
    private volatile List<Move> moves;

    public Game() {
        this.board = BoardInitializer.initBoard();
        this.currentTurn = Color.WHITE;
        this.whitePlayer = new Player(Color.WHITE, false);
        this.blackPlayer = new Player(Color.WHITE, false);
    }

    public static Game getInstance() {
        if (nonNull(instance)) {
            return instance;
        }

        synchronized (mutex) {
            if (isNull(instance)) {
                instance = new Game();
            }
            return instance;
        }
    }
}
