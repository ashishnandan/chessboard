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
        if (!checkInputRange()) {
            throw new InvalidInputException(location + " is not a valid move");
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
