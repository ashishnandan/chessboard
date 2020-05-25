package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;

import java.util.ArrayList;
import java.util.List;

public class Horse implements Piece {

    private Cell start;

    public Horse(String location) throws InvalidInputException {
        this.start = new Cell(location);
    }

    @Override
    public List<Cell> getAvailableSlots() {
        List<List<MovementDirection>> movementDirectionList = new ArrayList<>();

        List<MovementDirection> topRightList = new ArrayList<>();
        topRightList.add(MovementDirection.VERTICAL_TOP);
        topRightList.add(MovementDirection.VERTICAL_TOP);
        topRightList.add(MovementDirection.HORIZONTAL_RIGHT);

        List<MovementDirection> sideRightUpList = new ArrayList<>();
        sideRightUpList.add(MovementDirection.HORIZONTAL_RIGHT);
        sideRightUpList.add(MovementDirection.HORIZONTAL_RIGHT);
        sideRightUpList.add(MovementDirection.VERTICAL_TOP);

        List<MovementDirection> sideRightDownList = new ArrayList<>();
        sideRightDownList.add(MovementDirection.HORIZONTAL_RIGHT);
        sideRightDownList.add(MovementDirection.HORIZONTAL_RIGHT);
        sideRightDownList.add(MovementDirection.VERTICAL_BOTTOM);

        List<MovementDirection> downLeftList = new ArrayList<>();
        downLeftList.add(MovementDirection.VERTICAL_BOTTOM);
        downLeftList.add(MovementDirection.VERTICAL_BOTTOM);
        downLeftList.add(MovementDirection.HORIZONTAL_RIGHT);

        List<MovementDirection> downRightList = new ArrayList<>();
        downRightList.add(MovementDirection.VERTICAL_BOTTOM);
        downRightList.add(MovementDirection.VERTICAL_BOTTOM);
        downRightList.add(MovementDirection.HORIZONTAL_LEFT);

        List<MovementDirection> sideLeftDownList = new ArrayList<>();
        sideLeftDownList.add(MovementDirection.HORIZONTAL_LEFT);
        sideLeftDownList.add(MovementDirection.HORIZONTAL_LEFT);
        sideLeftDownList.add(MovementDirection.VERTICAL_BOTTOM);

        List<MovementDirection> sideLeftUpList = new ArrayList<>();
        sideLeftUpList.add(MovementDirection.HORIZONTAL_LEFT);
        sideLeftUpList.add(MovementDirection.HORIZONTAL_LEFT);
        sideLeftUpList.add(MovementDirection.VERTICAL_TOP);

        List<MovementDirection> topLeftList = new ArrayList<>();
        topLeftList.add(MovementDirection.VERTICAL_TOP);
        topLeftList.add(MovementDirection.VERTICAL_TOP);
        topLeftList.add(MovementDirection.HORIZONTAL_LEFT);


        movementDirectionList.add(topRightList);
        movementDirectionList.add(sideRightUpList);
        movementDirectionList.add(sideRightDownList);
        movementDirectionList.add(downLeftList);
        movementDirectionList.add(downRightList);
        movementDirectionList.add(sideLeftDownList);
        movementDirectionList.add(sideLeftUpList);
        movementDirectionList.add(topLeftList);

        List<Cell> availableMoves = new ArrayList<>();
        for (List<MovementDirection> list : movementDirectionList) {
            Cell newCell = start;
            for (MovementDirection direction : list) {
                newCell = direction.move(newCell);
            }
            if (newCell.getLocation() != null) {
                availableMoves.add(newCell);
            }
        }
        return availableMoves;
    }

}
