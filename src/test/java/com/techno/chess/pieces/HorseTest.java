package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HorseTest {

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots_F3 = new Horse().getAvailableSlots(new Cell("F3"));
        List<Cell> output = new ArrayList<>();

        output.add(new Cell("G5"));
        output.add(new Cell("H4"));
        output.add(new Cell("H2"));
        output.add(new Cell("G1"));
        output.add(new Cell("E1"));
        output.add(new Cell("D2"));
        output.add(new Cell("D4"));
        output.add(new Cell("E5"));

        assertEquals(output, availableSlots_F3);

        List<Cell> availableSlots_H2 = new Horse().getAvailableSlots(new Cell("H2"));
        output = new ArrayList<>();

        output.add(new Cell("F1"));
        output.add(new Cell("F3"));
        output.add(new Cell("G4"));

        assertEquals(output, availableSlots_H2);
    }
}