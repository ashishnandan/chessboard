package com.techno.chess.pieces;

import com.techno.chess.exception.InvalidInputException;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Arrays;

import static com.techno.chess.constants.Constants.PACKAGE_NAME_TO_APPEND;
import static com.techno.chess.constants.ExceptionConstants.INVALID_PIECE_MESSAGE;
import static com.techno.chess.constants.ExceptionConstants.INVOCATION_ERROR_MESSAGE;

public enum PieceType {
    KING("King"), QUEEN("Queen"), BISHOP("Bishop"), HORSE("Horse"), ROOK("Rook"), PAWN("Pawn");

    private String pieceType;

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
                throw new ClassNotFoundException(MessageFormat.format(INVALID_PIECE_MESSAGE, pieceType));
            }
            return (Piece) Class.forName(PACKAGE_NAME_TO_APPEND + type.pieceType)
                    .getConstructor(clzz).newInstance(new Object[]{constructorArgs});
        } catch (InvocationTargetException e) {
            throw new InvalidInputException(MessageFormat.format(INVOCATION_ERROR_MESSAGE, pieceType, constructorArgs));
        } catch (ClassNotFoundException e) {
            throw new InvalidInputException(MessageFormat.format(INVALID_PIECE_MESSAGE, pieceType));
        } catch (NoSuchMethodException e) {
            throw new InvalidInputException(e);
        } catch (IllegalAccessException e) {
            throw new InvalidInputException(e);
        } catch (InstantiationException e) {
            throw new InvalidInputException(e);
        }
    }
}
