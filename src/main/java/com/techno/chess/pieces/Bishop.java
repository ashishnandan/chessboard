package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.move.MovementDirection;
import com.techno.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    public Bishop() {
        movementDirectionList.add(MovementDirection.DIAGONAL_TOP_RIGHT);
        movementDirectionList.add(MovementDirection.DIAGONAL_BOTTOM_RIGHT);
        movementDirectionList.add(MovementDirection.DIAGONAL_BOTTOM_LEFT);
        movementDirectionList.add(MovementDirection.DIAGONAL_TOP_LEFT);
    }

    @Override
    public List<Cell> getAvailableSlots(Cell start) {
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
