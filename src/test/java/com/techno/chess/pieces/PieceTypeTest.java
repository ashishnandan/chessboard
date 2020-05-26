package com.techno.chess.pieces;

import com.techno.chess.exception.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTypeTest {

    @Test
    public void isValid() {
        assertTrue(PieceType.isValid("KING"));
        assertTrue(PieceType.isValid("king"));
        assertTrue(PieceType.isValid("QUEEN"));
        assertTrue(PieceType.isValid("queen"));
        assertTrue(PieceType.isValid("BISHOP"));
        assertTrue(PieceType.isValid("bishop"));
        assertTrue(PieceType.isValid("ROOK"));
        assertTrue(PieceType.isValid("rook"));
        assertTrue(PieceType.isValid("PAWN"));
        assertTrue(PieceType.isValid("pawn"));
        assertTrue(PieceType.isValid("HORSE"));
        assertTrue(PieceType.isValid("horse"));

        assertFalse(PieceType.isValid("kings"));
        assertFalse(PieceType.isValid("quen"));
        assertFalse(PieceType.isValid("axdfgh"));
        assertFalse(PieceType.isValid("Quee"));
        assertFalse(PieceType.isValid("Quene"));
        assertFalse(PieceType.isValid("Bis"));
        assertFalse(PieceType.isValid("shop"));
    }

    @Test
    public void getInstanceOf_validPieceNames() throws InvalidInputException {
        assertTrue(PieceType.getInstance("queen", String.class, "H6") instanceof Queen);
        assertTrue(PieceType.getInstance("King", String.class, "D8") instanceof King);
        assertTrue(PieceType.getInstance("PAWN", String.class, "F8") instanceof Pawn);
        assertTrue(PieceType.getInstance("ROok", String.class, "A1") instanceof Rook);
        assertTrue(PieceType.getInstance("BISHOP", String.class, "B2") instanceof Bishop);
        assertTrue(PieceType.getInstance("Horse", String.class, "H4") instanceof Horse);
    }

    @Test
    public void getInstanceOf_invalidPieceNames() {
        try {
            assertTrue(PieceType.getInstance("bhwcwhjds", String.class, "as") instanceof Queen);
            fail("Exception expected");
        } catch (InvalidInputException e) {
            assertEquals("PieceType bhwcwhjds not valid", e.getMessage());
        }
    }

    @Test
    public void getInstanceOf_invalidPieceMoves() {
        try {
            assertTrue(PieceType.getInstance("King", String.class, "Z1") instanceof Queen);
            fail("Exception expected");
        } catch (InvalidInputException e) {
            assertEquals("King Z1 is not a valid move", e.getMessage());
        }
    }
}