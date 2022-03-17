package chess.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import static chess.contants.BoardConstants.BOARD_HEIGHT;
import static chess.contants.BoardConstants.BOARD_WIDTH;

@Data
@NoArgsConstructor
public class Board {

    private Piece[][] pieces = new Piece[BOARD_WIDTH][BOARD_HEIGHT];

    public Piece getPieceLocation(final int x, final int y) { //method of  location piece object to finding
        return pieces[x][y];
    }


    public void setPiece(final Cell cell, final Piece piece) {
        pieces[cell.getX()][cell.getY()] = piece;
    }

}

