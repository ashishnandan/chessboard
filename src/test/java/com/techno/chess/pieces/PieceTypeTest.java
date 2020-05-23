package com.techno.chess.pieces;

import com.techno.chess.pieces.PieceType;
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
    public void getInstanceOf_validPieceNames() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        assertTrue(PieceType.getInstanceOf("queen").newInstance() instanceof Queen);
        assertTrue(PieceType.getInstanceOf("King").newInstance() instanceof King);
        assertTrue(PieceType.getInstanceOf("PAWN").newInstance() instanceof Pawn);
        assertTrue(PieceType.getInstanceOf("ROok").newInstance() instanceof Rook);
        assertTrue(PieceType.getInstanceOf("BISHOP").newInstance() instanceof Bishop);
        assertTrue(PieceType.getInstanceOf("Horse").newInstance() instanceof Horse);
    }

    @Test
    public void getInstanceOf_invalidPieceNames() {
        try {
            assertTrue(PieceType.getInstanceOf("bhwcwhjds").newInstance() instanceof Queen);
            fail("Exception expected");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            assertEquals("PieceType bhwcwhjds not valid", e.getMessage());
        }
    }
}