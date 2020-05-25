package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class King implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    private Cell start;

    public King(String location) throws InvalidInputException {
        this.start = new Cell(location);
        Collections.addAll(movementDirectionList, MovementDirection.values());
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection movementDirection : movementDirectionList) {
            Cell movedSlot = movementDirection.move(start);
            if (movedSlot.getLocation() != null) {
                availableMoves.add(movedSlot);
            }
        }
        return availableMoves;
    }

}
