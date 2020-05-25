package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RookTest {

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots_D5 = new Rook().getAvailableSlots(new Cell("D5"));
        assertEquals(14, availableSlots_D5.size());
        List<Cell> output = new ArrayList<>();
        output.add(new Cell("D6"));
        output.add(new Cell("D7"));
        output.add(new Cell("D8"));
        output.add(new Cell("E5"));
        output.add(new Cell("F5"));
        output.add(new Cell("G5"));
        output.add(new Cell("H5"));
        output.add(new Cell("D4"));
        output.add(new Cell("D3"));
        output.add(new Cell("D2"));
        output.add(new Cell("D1"));
        output.add(new Cell("C5"));
        output.add(new Cell("B5"));
        output.add(new Cell("A5"));

        assertEquals(output, availableSlots_D5);

        List<Cell> availableSlots_A8 = new Rook().getAvailableSlots(new Cell("A8"));
        assertEquals(14, availableSlots_A8.size());
        output = new ArrayList<>();
        output.add(new Cell("B8"));
        output.add(new Cell("C8"));
        output.add(new Cell("D8"));
        output.add(new Cell("E8"));
        output.add(new Cell("F8"));
        output.add(new Cell("G8"));
        output.add(new Cell("H8"));
        output.add(new Cell("A7"));
        output.add(new Cell("A6"));
        output.add(new Cell("A5"));
        output.add(new Cell("A4"));
        output.add(new Cell("A3"));
        output.add(new Cell("A2"));
        output.add(new Cell("A1"));

        assertEquals(output, availableSlots_A8);

        List<Cell> availableSlots_A4 = new Rook().getAvailableSlots(new Cell("A4"));
        assertEquals(14, availableSlots_A4.size());
        output = new ArrayList<>();
        output.add(new Cell("A5"));
        output.add(new Cell("A6"));
        output.add(new Cell("A7"));
        output.add(new Cell("A8"));
        output.add(new Cell("B4"));
        output.add(new Cell("C4"));
        output.add(new Cell("D4"));
        output.add(new Cell("E4"));
        output.add(new Cell("F4"));
        output.add(new Cell("G4"));
        output.add(new Cell("H4"));
        output.add(new Cell("A3"));
        output.add(new Cell("A2"));
        output.add(new Cell("A1"));

        assertEquals(output, availableSlots_A4);

    }
}