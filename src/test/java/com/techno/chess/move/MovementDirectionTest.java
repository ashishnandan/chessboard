package com.techno.chess.move;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovementDirectionTest {

    @Test
    public void move() throws InvalidInputException {
        Cell start = new Cell("D6");
        assertEquals("D7", (MovementDirection.VERTICAL_TOP).move(start).getLocation());
        assertEquals("E7", (MovementDirection.DIAGONAL_TOP_RIGHT).move(start).getLocation());
        assertEquals("E6", (MovementDirection.HORIZONTAL_RIGHT).move(start).getLocation());
        assertEquals("E5", (MovementDirection.DIAGONAL_BOTTOM_RIGHT).move(start).getLocation());
        assertEquals("D5", (MovementDirection.VERTICAL_BOTTOM).move(start).getLocation());
        assertEquals("C5", (MovementDirection.DIAGONAL_BOTTOM_LEFT).move(start).getLocation());
        assertEquals("C6", (MovementDirection.HORIZONTAL_LEFT).move(start).getLocation());
        assertEquals("C7", (MovementDirection.DIAGONAL_TOP_LEFT).move(start).getLocation());

        Cell start_A1 = new Cell("A1");
        assertEquals("A2", (MovementDirection.VERTICAL_TOP).move(start_A1).getLocation());
        assertNull((MovementDirection.HORIZONTAL_LEFT).move(start_A1).getLocation());
        assertNull((MovementDirection.VERTICAL_BOTTOM).move(start_A1).getLocation());
        assertNull((MovementDirection.DIAGONAL_BOTTOM_LEFT).move(start_A1).getLocation());

        Cell start_A8 = new Cell("A8");
        assertEquals("A7", (MovementDirection.VERTICAL_BOTTOM).move(start_A8).getLocation());
        assertNull((MovementDirection.HORIZONTAL_LEFT).move(start_A8).getLocation());
        assertNull((MovementDirection.VERTICAL_TOP).move(start_A8).getLocation());
        assertNull((MovementDirection.DIAGONAL_BOTTOM_LEFT).move(start_A8).getLocation());

    }
}