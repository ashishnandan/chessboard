package com.techno.chess.pieces;

import com.techno.chess.pieces.PieceType;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

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
    public void getInstanceOf_validPieceNames() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        assertTrue(PieceType.getInstanceOf("queen").getConstructor(String.class).newInstance(new Object[]{"H6"}) instanceof Queen);
        assertTrue(PieceType.getInstanceOf("King").getConstructor(String.class).newInstance(new Object[]{"D5"}) instanceof King);
        assertTrue(PieceType.getInstanceOf("PAWN").getConstructor(String.class).newInstance(new Object[]{"F8"}) instanceof Pawn);
        assertTrue(PieceType.getInstanceOf("ROok").getConstructor(String.class).newInstance(new Object[]{"A1"}) instanceof Rook);
        assertTrue(PieceType.getInstanceOf("BISHOP").getConstructor(String.class).newInstance(new Object[]{"B2"}) instanceof Bishop);
        assertTrue(PieceType.getInstanceOf("Horse").getConstructor(String.class).newInstance(new Object[]{"C4"}) instanceof Horse);
    }

    @Test
    public void getInstanceOf_invalidPieceNames() {
        try {
            assertTrue(PieceType.getInstanceOf("bhwcwhjds").getConstructor(String.class).newInstance(new Object[]{"random"})
                    instanceof Queen);
            fail("Exception expected");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            assertEquals("PieceType bhwcwhjds not valid", e.getMessage());
        }
    }
}