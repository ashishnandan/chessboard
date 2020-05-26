package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import com.techno.chess.move.MovementRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.techno.chess.move.MovementDirection.*;

public class Rook implements Piece, MovementRule {

    private Cell start;

    public Rook(String location) throws InvalidInputException {
        this.start = new Cell(location);
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection direction : getMovementRules()) {
            Cell newCell = start;
            while (newCell.getLocation() != null) {
                newCell = direction.move(newCell);
                if (newCell.getLocation() != null) {
                    availableMoves.add(newCell);
                }
            }
        }
        return availableMoves;
    }

    @Override
    public List<MovementDirection> getMovementRules() {
        return Arrays.asList(VERTICAL_TOP, HORIZONTAL_RIGHT, VERTICAL_BOTTOM, HORIZONTAL_LEFT);
    }
}
