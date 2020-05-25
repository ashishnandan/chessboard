package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();
    private final int step = 1;

    public King() {
        for (MovementDirection direction : MovementDirection.values())
            movementDirectionList.add(direction);
    }

    @Override
    public List<Cell> getAvailableSlots(Cell start) {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection movementDirection : movementDirectionList) {
            Cell movedSlot = movementDirection.move(start);
            if (movedSlot.getLocation() != null)
                availableMoves.add(movedSlot);
        }
        return availableMoves;
    }

}
