package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import com.techno.chess.move.MovementRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.techno.chess.move.MovementDirection.DIAGONAL_TOP_RIGHT;
import static com.techno.chess.move.MovementDirection.VERTICAL_TOP;

/*
Probable move does not include the diagonal move in order to eliminate the opposing piece as piece wont have that information
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
        return Collections.singletonList(VERTICAL_TOP);
    }

    public Cell getCell() {
        return start;
    }

    public List<Cell> addDiagonalSlotsOfPawn(List<Piece> pieces) {
        List<Cell> availableSlots = new ArrayList<>();
        for (MovementDirection direction : Arrays.asList(DIAGONAL_TOP_RIGHT, MovementDirection.DIAGONAL_TOP_LEFT)) {
            Cell newCell = direction.move(start);
            if (newCell.getLocation() != null && pieces.stream().anyMatch(piece1 -> piece1.getCell().equals(newCell))) {
                availableSlots.add(newCell);
            }
        }
        return availableSlots;
    }
}
