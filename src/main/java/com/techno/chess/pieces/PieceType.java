package com.techno.chess.pieces;

import com.techno.chess.exception.InvalidInputException;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum PieceType {
    KING("King"), QUEEN("Queen"), BISHOP("Bishop"), HORSE("Horse"), ROOK("Rook"), PAWN("Pawn");

    private String pieceType;
    private static final String packageNameToAppend = "com.techno.chess.pieces.";

    PieceType(String piece) {
        this.pieceType = piece;
    }

    public static boolean isValid(String s) {
        PieceType[] pieceTypes = PieceType.values();
        return Arrays.stream(pieceTypes).anyMatch(pieceType -> pieceType.toString().equalsIgnoreCase(s));
    }

    public static Piece getInstance(String pieceType, Class<String> clzz, String constructorArgs) throws
            NoSuchMethodException, IllegalAccessException, InstantiationException, InvalidInputException {

        PieceType type;
        try {
            if (isValid(pieceType)) {
                type = PieceType.valueOf(pieceType.toUpperCase());
            } else {
                throw new ClassNotFoundException("PieceType " + pieceType + " not valid");
            }
            return (Piece) Class.forName(packageNameToAppend + type.pieceType)
                    .getConstructor(clzz).newInstance(new Object[]{constructorArgs});
        } catch (InvocationTargetException | ClassNotFoundException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
