package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import com.techno.chess.move.MovementRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.techno.chess.move.MovementDirection.*;

/*
Probable move also includes the diagonal move in order to eliminate the opposing piece
 */
public class Pawn implements Piece, MovementRule {

    private Cell start;

    public Pawn(String location) throws InvalidInputException {
        this.start = new Cell(location);
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<Cell> availableMoves = new ArrayList<>();
        for (MovementDirection movementDirection : getMovementRules()) {
            Cell movedSlot = movementDirection.move(start);
            if (movedSlot.getLocation() != null) {
                availableMoves.add(movedSlot);
            }
        }
        return availableMoves;
    }

    @Override
    public List<MovementDirection> getMovementRules() {
        return Arrays.asList(VERTICAL_TOP, DIAGONAL_TOP_RIGHT, DIAGONAL_TOP_LEFT);
    }
}
