package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {

    @Before
    public void setUp() {
    }

    @Test
    public void getAvailableSlots() throws InvalidInputException {
        Map<String, String> inputOutputMap = new HashMap<>();
        inputOutputMap.put("King D5", "D6, E6, E5, E4, D4, C4, C5, C6");
        inputOutputMap.put("Rook C2", "C3, C4, C5, C6, C7, C8, D2, E2, F2, G2, H2, C1, B2, A2");
        inputOutputMap.put("Queen H1", "H2, H3, H4, H5, H6, H7, H8, G1, F1, E1, D1, C1, B1, A1, G2, F3, E4, D5, C6, B7, A8");
        inputOutputMap.put("Bishop E3", "F4, G5, H6, F2, G1, D2, C1, D4, C5, B6, A7");
        inputOutputMap.put("Horse A6", "B8, C7, C5, B4");
        inputOutputMap.put("Pawn A4", "A5, B5");
        inputOutputMap.put("Pawn E8", "");

        for (String input: inputOutputMap.keySet()) {
            assertEquals(inputOutputMap.get(input), new ChessBoard(input).getAvailableMoves());
        }
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_King_InvalidMove() throws InvalidInputException {

        new ChessBoard("Kin F99").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_King_InvalidPiece() throws InvalidInputException {

        new ChessBoard("Kin F5").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_Queen_InvalidPiece() throws InvalidInputException {

        new ChessBoard("Queens F5").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_King_InvalidMove_OutsideRange() throws InvalidInputException {

        new ChessBoard("King Z8").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_Queen_InvalidMove_OutsideRange() throws InvalidInputException {

        new ChessBoard("Queen M6").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_Rook_InvalidMove_OutsideRange() throws InvalidInputException {

        new ChessBoard("Rook Y1").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_Horse_InvalidMove_OutsideRange() throws InvalidInputException {

        new ChessBoard("Horse W4").getAvailableMoves();
    }

    @Test(expected = InvalidInputException.class)
    public void getAvailableSlots_EmptyMove() throws InvalidInputException {

        new ChessBoard("").getAvailableMoves();
    }
}