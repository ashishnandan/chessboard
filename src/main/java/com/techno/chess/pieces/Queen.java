package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.techno.chess.move.MovementDirection.*;

public class Queen implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    public Queen() {
        Collections.addAll(movementDirectionList, values());
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
