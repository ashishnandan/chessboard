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
        return Arrays.stream(PieceType.values()).anyMatch(pieceType -> pieceType.toString().equalsIgnoreCase(s));
    }

    public static Piece getInstance(String pieceType, Class<String> clzz, String constructorArgs)
            throws InvalidInputException {

        PieceType type;
        try {
            if (isValid(pieceType)) {
                type = PieceType.valueOf(pieceType.toUpperCase());
            } else {
                throw new ClassNotFoundException("PieceType " + pieceType + " not valid");
            }
            return (Piece) Class.forName(packageNameToAppend + type.pieceType)
                    .getConstructor(clzz).newInstance(new Object[]{constructorArgs});
        } catch (InvocationTargetException e) {
            throw new InvalidInputException(pieceType + " " + constructorArgs + " is not a valid move");
        } catch (ClassNotFoundException e) {
            throw new InvalidInputException("PieceType " + pieceType + " not valid");
        } catch (NoSuchMethodException e) {
            throw new InvalidInputException(e);
        } catch (IllegalAccessException e) {
            throw new InvalidInputException(e);
        } catch (InstantiationException e) {
            throw new InvalidInputException(e);
        }
    }
}
