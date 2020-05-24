package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.move.MovementDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {


    @Test
    public void getMovedSlot() throws InvalidInputException {
        Cell start = new Cell("D6");
        assertEquals("D7", start.getMovedSlot(MovementDirection.VERTICAL_TOP, 1).getLocation());
        assertEquals("E7", start.getMovedSlot(MovementDirection.DIAGONAL_TOP_RIGHT, 1).getLocation());
        assertEquals("E6", start.getMovedSlot(MovementDirection.HORIZONTAL_RIGHT, 1).getLocation());
        assertEquals("E5", start.getMovedSlot(MovementDirection.DIAGONAL_BOTTOM_RIGHT, 1).getLocation());
        assertEquals("D5", start.getMovedSlot(MovementDirection.VERTICAL_BOTTOM, 1).getLocation());
        assertEquals("C5", start.getMovedSlot(MovementDirection.DIAGONAL_BOTTOM_LEFT, 1).getLocation());
        assertEquals("C6", start.getMovedSlot(MovementDirection.HORIZONTAL_LEFT, 1).getLocation());
        assertEquals("C7", start.getMovedSlot(MovementDirection.DIAGONAL_TOP_LEFT, 1).getLocation());

        Cell start_A1 = new Cell("A1");
        assertEquals("A2", start_A1.getMovedSlot(MovementDirection.VERTICAL_TOP, 1).getLocation());
        assertNull(start_A1.getMovedSlot(MovementDirection.HORIZONTAL_LEFT, 1).getLocation());
        assertNull(start_A1.getMovedSlot(MovementDirection.VERTICAL_BOTTOM, 1).getLocation());
        assertNull(start_A1.getMovedSlot(MovementDirection.DIAGONAL_BOTTOM_LEFT, 1).getLocation());

        Cell start_A8 = new Cell("A8");
        assertEquals("A7", start_A8.getMovedSlot(MovementDirection.VERTICAL_BOTTOM, 1).getLocation());
        assertNull(start_A8.getMovedSlot(MovementDirection.HORIZONTAL_LEFT, 1).getLocation());
        assertNull(start_A8.getMovedSlot(MovementDirection.VERTICAL_TOP, 1).getLocation());
        assertNull(start_A8.getMovedSlot(MovementDirection.DIAGONAL_BOTTOM_LEFT, 1).getLocation());
    }
}