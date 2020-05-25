package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ChessBoardTest {

    @Before
    public void setUp() {
    }

    @Test
    public void getAvailableSlots() throws
            IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidInputException {
        Map<String, String> inputOutputMap = new HashMap<>();
        inputOutputMap.put("King D5", "D6, E6, E5, E4, D4, C4, C5, C6");
        inputOutputMap.put("King A1", "A2, B2, B1");
        inputOutputMap.put("Queen H1", "H2, H3, H4, H5, H6, H7, H8, G1, F1, E1, D1, C1, B1, A1, G2, F3, E4, D5, C6, B7, A8");
        inputOutputMap.put("King A8", "B8, B7, A7");
        inputOutputMap.put("King H8", "H7, G7, G8");
        inputOutputMap.put("King A4", "A5, B5, B4, B3, A3");
        inputOutputMap.put("King H4", "H5, H3, G3, G4, G5");

        for (String input: inputOutputMap.keySet())
            assertEquals(inputOutputMap.get(input), new ChessBoard(input).getAvailableMoves());
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_King_InvalidMove() throws
            IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidInputException {

        new ChessBoard("Kin F99").getAvailableMoves();
    }

    @Test(expected = ClassNotFoundException.class)
    public void getAvailableSlots_King_InvalidPiece() throws
            IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidInputException {

        new ChessBoard("Kin F5").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_King_InvalidMove_OutsideRange() throws
            IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidInputException {

        new ChessBoard("King Z8").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_Queen_InvalidMove_OutsideRange() throws
            IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidInputException {

        new ChessBoard("Queen M6").getAvailableMoves();
    }
}