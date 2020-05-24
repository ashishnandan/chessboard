package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;

import java.util.Arrays;
import java.util.Objects;

public class Cell {

    private String location;
    private char xAxis;
    private int yAxis;

    private final Character[] xAxisRange = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private final int[] yAxisRange = {1, 2, 3, 4, 5, 6, 7, 8};

    public Cell(Character xAxis, int yAxis) {
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        if (checkInputRange()) {
            location = xAxis.toString() + yAxis;
        }
    }

    public Cell(String s) throws InvalidInputException {
        this.location = s;
        xAxis = location.charAt(0);
        yAxis = Integer.parseInt(String.valueOf(location.charAt(1)));
        if (!checkInputRange())
            throw new InvalidInputException(location + " is not a valid move");
    }


    public String getLocation() {
        return location;
    }

    public Cell getMovedSlot(MovementDirection movementDirection, int step) {
        Cell newCell = null;
        char x;
        int y;
        if (movementDirection == MovementDirection.VERTICAL_TOP) {
            x = xAxis;
            y = yAxis + step;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.DIAGONAL_TOP_RIGHT) {
            x = (char) (xAxis + 1);
            y = yAxis + step;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.HORIZONTAL_RIGHT) {
            x = (char) (xAxis + 1);
            y = yAxis;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.DIAGONAL_BOTTOM_RIGHT) {
            x = (char) (xAxis + 1);
            y = yAxis - step;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.VERTICAL_BOTTOM) {
            x = xAxis;
            y = yAxis - step;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.DIAGONAL_BOTTOM_LEFT) {
            x = (char) (xAxis - 1);
            y = yAxis - step;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.HORIZONTAL_LEFT) {
            x = (char) (xAxis - 1);
            y = yAxis;
            newCell = new Cell(x, y);
        } else if (movementDirection == MovementDirection.DIAGONAL_TOP_LEFT) {
            x = (char) (xAxis - 1);
            y = yAxis + step;
            newCell = new Cell(x, y);
        }
        return newCell;
    }

    public boolean checkInputRange() {
        return Arrays.stream(xAxisRange).anyMatch(x -> x.equals(xAxis))
                && Arrays.stream(yAxisRange).anyMatch(y -> y == yAxis);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return location.equals(cell.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return location;
    }
}
