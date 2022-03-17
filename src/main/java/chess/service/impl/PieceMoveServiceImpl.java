package chess.service.impl;

import chess.enums.PieceType;
import chess.model.Move;
import chess.model.Piece;
import chess.service.PieceMoveService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static chess.utils.validator.piece.PieceMoveValidator.areCoordinatesInBound;
import static java.util.Objects.isNull;


public class PieceMoveServiceImpl implements PieceMoveService {
    private final Map<PieceType, PieceMoveService> strategies;

    public PieceMoveServiceImpl(final List<PieceMoveService> strategies) {
        this.strategies = strategies.stream().collect(Collectors
                .toMap(PieceMoveService::pieceTypeHandler, Function.identity()));
    }

    @Override
    public PieceType pieceTypeHandler() {
        return null;
    }

    @Override
    public boolean canBeMoved(final Piece piece, final Move move) {
        if (!strategies.containsKey(piece.getPieceType()) || isNull(move)) {
            return false;
        }
        final int x1 = move.getStart().getX();
        final int y1 = move.getStart().getY();
        final int x2 = move.getEnd().getX();
        final int y2 = move.getEnd().getY();

        if (!areCoordinatesInBound(x1, y1, x2, y2)) {
            return false;
        }

        return strategies.get(piece.getPieceType()).canBeMoved(x1, y1, x2, y2);
    }

    @Override
    public boolean canBeMoved(final int x1, final int y1, final int x2, final int y2) {
        return false;
    }
}
