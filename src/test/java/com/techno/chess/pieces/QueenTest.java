package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueenTest {

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots_D5 = new Queen("D5").getAvailableSlots();
        assertEquals(27, availableSlots_D5.size());
        List<Cell> output = new ArrayList<>();
        output.add(new Cell("D6"));
        output.add(new Cell("D7"));
        output.add(new Cell("D8"));
        output.add(new Cell("E6"));
        output.add(new Cell("F7"));
        output.add(new Cell("G8"));
        output.add(new Cell("E5"));
        output.add(new Cell("F5"));
        output.add(new Cell("G5"));
        output.add(new Cell("H5"));
        output.add(new Cell("E4"));
        output.add(new Cell("F3"));
        output.add(new Cell("G2"));
        output.add(new Cell("H1"));
        output.add(new Cell("D4"));
        output.add(new Cell("D3"));
        output.add(new Cell("D2"));
        output.add(new Cell("D1"));
        output.add(new Cell("C4"));
        output.add(new Cell("B3"));
        output.add(new Cell("A2"));
        output.add(new Cell("C5"));
        output.add(new Cell("B5"));
        output.add(new Cell("A5"));
        output.add(new Cell("C6"));
        output.add(new Cell("B7"));
        output.add(new Cell("A8"));

        assertEquals(output, availableSlots_D5);

        List<Cell> availableSlots_A1 = new Queen("A1").getAvailableSlots();
        assertEquals(21, availableSlots_A1.size());
        output = new ArrayList<>();
        output.add(new Cell("A2"));
        output.add(new Cell("A3"));
        output.add(new Cell("A4"));
        output.add(new Cell("A5"));
        output.add(new Cell("A6"));
        output.add(new Cell("A7"));
        output.add(new Cell("A8"));
        output.add(new Cell("B2"));
        output.add(new Cell("C3"));
        output.add(new Cell("D4"));
        output.add(new Cell("E5"));
        output.add(new Cell("F6"));
        output.add(new Cell("G7"));
        output.add(new Cell("H8"));
        output.add(new Cell("B1"));
        output.add(new Cell("C1"));
        output.add(new Cell("D1"));
        output.add(new Cell("E1"));
        output.add(new Cell("F1"));
        output.add(new Cell("G1"));
        output.add(new Cell("H1"));

        assertEquals(output, availableSlots_A1);

        List<Cell> availableSlots_H4 = new Queen("H4").getAvailableSlots();
        assertEquals(21, availableSlots_H4.size());
        output = new ArrayList<>();
        output.add(new Cell("H5"));
        output.add(new Cell("H6"));
        output.add(new Cell("H7"));
        output.add(new Cell("H8"));
        output.add(new Cell("H3"));
        output.add(new Cell("H2"));
        output.add(new Cell("H1"));
        output.add(new Cell("G3"));
        output.add(new Cell("F2"));
        output.add(new Cell("E1"));
        output.add(new Cell("G4"));
        output.add(new Cell("F4"));
        output.add(new Cell("E4"));
        output.add(new Cell("D4"));
        output.add(new Cell("C4"));
        output.add(new Cell("B4"));
        output.add(new Cell("A4"));
        output.add(new Cell("G5"));
        output.add(new Cell("F6"));
        output.add(new Cell("E7"));
        output.add(new Cell("D8"));

        assertEquals(output, availableSlots_H4);

        List<Cell> availableSlots_A5 = new Queen("A5").getAvailableSlots();
        assertEquals(21, availableSlots_A5.size());
        output = new ArrayList<>();
        output.add(new Cell("A6"));
        output.add(new Cell("A7"));
        output.add(new Cell("A8"));
        output.add(new Cell("B6"));
        output.add(new Cell("C7"));
        output.add(new Cell("D8"));
        output.add(new Cell("B5"));
        output.add(new Cell("C5"));
        output.add(new Cell("D5"));
        output.add(new Cell("E5"));
        output.add(new Cell("F5"));
        output.add(new Cell("G5"));
        output.add(new Cell("H5"));
        output.add(new Cell("B4"));
        output.add(new Cell("C3"));
        output.add(new Cell("D2"));
        output.add(new Cell("E1"));
        output.add(new Cell("A4"));
        output.add(new Cell("A3"));
        output.add(new Cell("A2"));
        output.add(new Cell("A1"));

        assertEquals(output, availableSlots_A5);
    }
}