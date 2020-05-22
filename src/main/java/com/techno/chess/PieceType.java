package com.techno.chess;

import java.util.Arrays;

public enum PieceType {
    KING, QUEEN, BISHOP, HORSE, ROOK, PAWN;

    public static boolean isValid(String s){
        PieceType[] pieceTypes = PieceType.values();
        return Arrays.stream(pieceTypes).anyMatch(pieceType -> pieceType.toString().equalsIgnoreCase(s));
    }
}
