package chess.service.impl;

import chess.enums.Color;
import chess.model.Board;
import chess.model.Cell;
import chess.model.Game;
import chess.model.Move;
import chess.model.Piece;
import chess.service.BoardService;
import chess.service.GameService;
import chess.service.MoveService;
import chess.service.PieceMoveService;
import chess.service.mapper.PiecePositionMapper;
import chess.service.strategy.BishopMoveStrategy;
import chess.service.strategy.KingMoveStrategy;
import chess.service.strategy.KnightMoveStrategy;
import chess.service.strategy.PawnMoveStrategy;
import chess.service.strategy.QueenMoveStrategy;
import chess.service.strategy.RookMoveStrategy;
import chess.utils.BoardPrinter;

import java.util.List;
import java.util.Objects;

import static chess.contants.MessageConstants.CANT_MOVE_MSG;
import static chess.contants.MessageConstants.CHECKMATE_MSG;
import static chess.contants.MessageConstants.CHECK_MSG;
import static chess.contants.MessageConstants.INVALID_PIECE_MSG;
import static chess.contants.MessageConstants.INVALID_POSITION_MSG;
import static chess.contants.MessageConstants.MOVED_MSG;
import static chess.utils.DialogPrinter.retrieveCoords;
import static chess.utils.validator.GameValidator.isChecked;
import static chess.utils.validator.GameValidator.isCheckmate;
import static java.util.Objects.nonNull;

public class GameServiceImpl implements GameService {
    private final List<PieceMoveService> strategies = List.of(
            new BishopMoveStrategy(),
            new KingMoveStrategy(),
            new KnightMoveStrategy(),
            new PawnMoveStrategy(),
            new QueenMoveStrategy(),
            new RookMoveStrategy());
    private final PieceMoveService pieceMoveService = new PieceMoveServiceImpl(strategies);
    private final BoardService boardService = new BoardServiceImpl();
    private final PiecePositionMapper mapper = new PiecePositionMapper();
    private final MoveService moveService = new MoveServiceImpl();

    @Override
    public void startGame() {
        BoardPrinter.showBoard();
        initGameLogics();
    }

    private void initGameLogics() {
        final Game game = Game.getInstance();
        final Board board = game.getBoard();
        boolean isGameOver = false;
        while (!isGameOver) {
            final List<String> coords = retrieveCoords();
            final int y1 = mapper.mapSymbolic(coords.get(0));
            final int x1 = mapper.mapNumeric(coords.get(1));
            final int y2 = mapper.mapSymbolic(coords.get(2));
            final int x2 = mapper.mapNumeric(coords.get(3));
            final Move move = moveService.buildMoveFromCoords(x1, y1, x2, y2);
            Piece piece = board.getPieceLocation(x1, y1);
            if (nonNull(piece) && Objects.equals(game.getCurrentTurn(), piece.getColor())) {
                isGameOver = play(piece, move);
            } else {
                System.out.println(INVALID_PIECE_MSG);
            }
        }
    }

    private boolean play(final Piece piece, final Move move) {
        final Cell start = move.getStart();
        final Cell end = move.getEnd();
        boolean canPlay = false;
        boolean canBeMoved = pieceMoveService.canBeMoved(piece, move);
        if (canBeMoved) {
            changeTurn();
            boardService.movePieceOnBoard(piece, start, end);
            boolean isChecked = isChecked();
            if (isChecked) {
                boardService.movePieceOnBoard(piece, end, start);
            }
            changeTurn();

            if (isChecked()) {
                canPlay = determineCheckOrCheckmate();
            } else {
                makeAndValidateMove(isChecked, piece, start, end);

            }
        } else {
            System.out.println(INVALID_POSITION_MSG);
        }
        BoardPrinter.showBoard();
        return canPlay;
    }

    @Override
    public void changeTurn() {
        final Game game = Game.getInstance();
        Color currentColor = game.getCurrentTurn();
        Color playerColor = Color.WHITE.equals(currentColor) ? Color.BLACK : Color.WHITE;
        game.setCurrentTurn(playerColor);
    }

    private void makeAndValidateMove(boolean isChecked, Piece piece, Cell start, Cell end) {
        if (!isChecked) {
            boardService.movePieceOnBoard(piece, start, end);
            System.out.println(MOVED_MSG);
            changeTurn();
        } else {
            System.out.println(CANT_MOVE_MSG);
        }
    }

    private boolean determineCheckOrCheckmate() {
        if (isCheckmate()) {
            System.out.println(CHECKMATE_MSG);
            return true;
        } else {
            System.out.println(CHECK_MSG);
            changeTurn();
        }
        return false;
    }
}
