package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.HorseMovementDirection;
import com.techno.chess.move.HorseMovementRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse implements Piece, HorseMovementRule {

    private Cell start;

    public Horse(String location) throws InvalidInputException {
        this.start = new Cell(location);
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();

        for (HorseMovementDirection direction : getMovementRules()) {
            Cell newCell = direction.move(start);
            if (newCell.getLocation() != null) {
                availableMoves.add(newCell);
            }
        }
        return availableMoves;
    }

    @Override
    public List<HorseMovementDirection> getMovementRules() {
        return Arrays.asList(HorseMovementDirection.values());
    }
}
