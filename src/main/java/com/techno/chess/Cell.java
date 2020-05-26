package com.techno.chess;

import com.techno.chess.constants.ExceptionConstants;
import com.techno.chess.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

import static com.techno.chess.constants.Constants.X_AXIS_RANGE;
import static com.techno.chess.constants.Constants.Y_AXIS_RANGE;
import static com.techno.chess.constants.ExceptionConstants.INVALID_MOVE_MESSAGE;
import static java.text.MessageFormat.format;

public class Cell {

    private String location;
    private char xAxis;
    private int yAxis;

    private Cell(Character xAxis, int yAxis) {
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
        if (location.length()!= 2 || !checkInputRange()) {
            throw new InvalidInputException(format(INVALID_MOVE_MESSAGE, location));
        }
    }


    public String getLocation() {
        return location;
    }

    public Cell moveUp() {
        int y = yAxis + 1;
        return new Cell(xAxis, y);
    }

    public Cell moveUpDiagonalRight() {
        char x = (char) (xAxis + 1);
        int y = yAxis + 1;
        return new Cell(x, y);
    }

    public Cell moveRight() {
        char x = (char) (xAxis + 1);
        return new Cell(x, yAxis);
    }

    public Cell moveDownDiagonalRight() {
        return new Cell((char) (xAxis + 1), yAxis - 1);
    }

    public Cell moveDown() {
        return new Cell(xAxis, yAxis - 1);
    }

    public Cell moveDownDiagonalLeft() {
        return new Cell((char) (xAxis - 1), yAxis - 1);
    }

    public Cell moveUpDiagonalLeft() {
        return new Cell((char) (xAxis - 1), yAxis + 1);
    }

    public Cell moveLeft() {
        return new Cell((char) (xAxis - 1), yAxis);
    }

    private boolean checkInputRange() {
        return Arrays.stream(X_AXIS_RANGE).anyMatch(x -> x.equals(xAxis))
                && Arrays.stream(Y_AXIS_RANGE).anyMatch(y -> y == yAxis);
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
