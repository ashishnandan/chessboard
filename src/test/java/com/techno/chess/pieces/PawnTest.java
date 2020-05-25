package com.techno.chess.pieces;

import com.techno.chess.Cell;
import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        List<Cell> availableSlots = new Pawn("D5").getAvailableSlots();
        List<Cell> output = new ArrayList<>();
        output.add(new Cell("D6"));
        output.add(new Cell("E6"));
        output.add(new Cell("C6"));

        assertEquals(output, availableSlots);

        List<Cell> availableSlots_C8 = new Pawn("C8").getAvailableSlots();

        assertEquals(emptyList(), availableSlots_C8);
    }
}