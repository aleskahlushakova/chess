package chess.service.impl;

import chess.enums.Color;
import chess.model.Game;
import chess.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    private final GameService service = new GameServiceImpl();
    @Test
    void changeTurn() {
        //given
        Game game = Game.getInstance();
        Color expected = Color.BLACK;

        //when
        service.changeTurn();
        Color actual = game.getCurrentTurn();

        //then
        Assertions.assertEquals(actual, expected);
    }
}