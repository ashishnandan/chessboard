package com.techno.chess.pieces;

import java.util.Arrays;

public enum PieceType {
    KING("King"), QUEEN("Queen"), BISHOP("Bishop"), HORSE("Horse"), ROOK("Rook"), PAWN("Pawn");

    private String pieceType;
    private static final String packageNameToAppend= "com.techno.chess.pieces.";

    PieceType(String piece) {
        this.pieceType = piece;
    }

    public static boolean isValid(String s) {
        PieceType[] pieceTypes = PieceType.values();
        return Arrays.stream(pieceTypes).anyMatch(pieceType -> pieceType.toString().equalsIgnoreCase(s));
    }

    public static Class<?> getInstanceOf(String pieceType) throws ClassNotFoundException {
        PieceType type;
        if (isValid(pieceType))
            type = PieceType.valueOf(pieceType.toUpperCase());
        else
            throw new ClassNotFoundException("PieceType " + pieceType + " not valid");
        return Class.forName(packageNameToAppend + type.pieceType);
    }
}
