package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.techno.chess.move.MovementDirection.values;

public class Queen implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    private Cell start;

    public Queen(String location) throws InvalidInputException {
        this.start = new Cell(location);
        Collections.addAll(movementDirectionList, values());
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection direction : movementDirectionList) {
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
}
