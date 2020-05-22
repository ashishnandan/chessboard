package com.techno.chess;

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
}