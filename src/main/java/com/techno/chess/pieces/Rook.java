package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import com.techno.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    private Cell start;
    public Rook(String location) throws InvalidInputException {
        this.start = new Cell(location);
        movementDirectionList.add(MovementDirection.VERTICAL_TOP);
        movementDirectionList.add(MovementDirection.HORIZONTAL_RIGHT);
        movementDirectionList.add(MovementDirection.VERTICAL_BOTTOM);
        movementDirectionList.add(MovementDirection.HORIZONTAL_LEFT);
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection direction : movementDirectionList) {
            Cell newCell = start;
            while (newCell.getLocation() != null) {
                newCell = direction.move(newCell);
                if (newCell.getLocation() != null)
                    availableMoves.add(newCell);
            }
        }
        return availableMoves;
    }
}
