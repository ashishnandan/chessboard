package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.List;

/*
Probable move also includes the diagonal move in order to eliminate the opposing piece
 */
public class Pawn implements Piece {

    private final List<MovementDirection> movementDirectionList = new ArrayList<>();

    private Cell start;

    public Pawn(String location) throws InvalidInputException {
        this.start = new Cell(location);
        movementDirectionList.add(MovementDirection.VERTICAL_TOP);
        movementDirectionList.add(MovementDirection.DIAGONAL_TOP_RIGHT);
        movementDirectionList.add(MovementDirection.DIAGONAL_TOP_LEFT);
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
