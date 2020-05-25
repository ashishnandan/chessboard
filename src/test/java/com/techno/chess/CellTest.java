package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {


    @Test
    public void moveUp() throws InvalidInputException {
        assertEquals("D6", new Cell("D5").moveUp().getLocation());
        assertNull(new Cell("D8").moveUp().getLocation());
    }

    @Test
    public void moveUpDiagonalRight() throws InvalidInputException {
        assertEquals("E6", new Cell("D5").moveUpDiagonalRight().getLocation());
        assertNull(new Cell("D8").moveUpDiagonalRight().getLocation());
    }

    @Test
    public void moveRight() throws InvalidInputException {
        assertEquals("E5", new Cell("D5").moveRight().getLocation());
        assertNull(new Cell("H8").moveRight().getLocation());
    }

    @Test
    public void moveDownDiagonalRight() throws InvalidInputException {
        assertEquals("E4", new Cell("D5").moveDownDiagonalRight().getLocation());
        assertNull(new Cell("H1").moveDownDiagonalRight().getLocation());
    }

    @Test
    public void moveDown() throws InvalidInputException {
        assertEquals("D4", new Cell("D5").moveDown().getLocation());
        assertNull(new Cell("H1").moveDown().getLocation());
    }

    @Test
    public void moveDownDiagonalLeft() throws InvalidInputException {
        assertEquals("C4", new Cell("D5").moveDownDiagonalLeft().getLocation());
        assertNull(new Cell("H1").moveDownDiagonalLeft().getLocation());
    }

    @Test
    public void moveUpDiagonalLeft() throws InvalidInputException {
        assertEquals("C6", new Cell("D5").moveUpDiagonalLeft().getLocation());
        assertNull(new Cell("H8").moveUpDiagonalLeft().getLocation());
    }

    @Test
    public void moveLeft() throws InvalidInputException {
        assertEquals("C5", new Cell("D5").moveLeft().getLocation());
        assertNull(new Cell("A1").moveLeft().getLocation());
    }
}