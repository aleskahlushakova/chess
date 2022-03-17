package chess.service;

/**
 * Service responsible for {@link chess.model.Game} logics.
 */
public interface GameService {
    /**
     * Initial method that creates Game, initializes Board and all
     * game logics.
     */
    void startGame();

    /**
     * Changes {@link chess.enums.Color} in {@link chess.model.Game}.
     * Triggered on made move
     */
    void changeTurn();
}
