package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KingTest {


    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots = new King().getAvailableSlots(new Cell("D5"));
        assertEquals(8, availableSlots.size());
        List<Cell> output = new ArrayList<>();
        output.add(new Cell("D6"));
        output.add(new Cell("E6"));
        output.add(new Cell("E5"));
        output.add(new Cell("E4"));
        output.add(new Cell("D4"));
        output.add(new Cell("C4"));
        output.add(new Cell("C5"));
        output.add(new Cell("C6"));

        assertEquals(output, availableSlots);

        List<Cell> availableSlots_1 = new King().getAvailableSlots(new Cell("H1"));
        assertEquals(3, availableSlots_1.size());
        List<Cell> output_1 = new ArrayList<>();
        output_1.add(new Cell("H2"));
        output_1.add(new Cell("G1"));
        output_1.add(new Cell("G2"));

        assertEquals(output_1, availableSlots_1);

        List<Cell> availableSlots_2 = new King().getAvailableSlots(new Cell("H8"));
        assertEquals(3, availableSlots_2.size());
        List<Cell> output_2 = new ArrayList<>();
        output_2.add(new Cell("H7"));
        output_2.add(new Cell("G7"));
        output_2.add(new Cell("G8"));

        assertEquals(output_2, availableSlots_2);

        List<Cell> availableSlots_3 = new King().getAvailableSlots(new Cell("A5"));
        assertEquals(5, availableSlots_3.size());
        List<Cell> output_3 = new ArrayList<>();
        output_3.add(new Cell("A6"));
        output_3.add(new Cell("B6"));
        output_3.add(new Cell("B5"));
        output_3.add(new Cell("B4"));
        output_3.add(new Cell("A4"));

        assertEquals(output_3, availableSlots_3);
    }
}