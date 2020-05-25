package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots_D5 = new Bishop().getAvailableSlots(new Cell("D5"));
        assertEquals(13, availableSlots_D5.size());
        List<Cell> output = new ArrayList<>();
        output.add(new Cell("E6"));
        output.add(new Cell("F7"));
        output.add(new Cell("G8"));
        output.add(new Cell("E4"));
        output.add(new Cell("F3"));
        output.add(new Cell("G2"));
        output.add(new Cell("H1"));
        output.add(new Cell("C4"));
        output.add(new Cell("B3"));
        output.add(new Cell("A2"));
        output.add(new Cell("C6"));
        output.add(new Cell("B7"));
        output.add(new Cell("A8"));

        assertEquals(output, availableSlots_D5);

        List<Cell> availableSlots_A1 = new Bishop().getAvailableSlots(new Cell("A1"));
        assertEquals(7, availableSlots_A1.size());
        output = new ArrayList<>();
        output.add(new Cell("B2"));
        output.add(new Cell("C3"));
        output.add(new Cell("D4"));
        output.add(new Cell("E5"));
        output.add(new Cell("F6"));
        output.add(new Cell("G7"));
        output.add(new Cell("H8"));

        assertEquals(output, availableSlots_A1);
    }
}