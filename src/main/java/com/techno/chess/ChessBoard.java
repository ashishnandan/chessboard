package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.pieces.Piece;
import com.techno.chess.pieces.PieceType;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ChessBoard {

    private String input;

    public ChessBoard(String input) {
        this.input = input;
    }


    public String getAvailableMoves() throws
            ClassNotFoundException, IllegalAccessException, InstantiationException, InvalidInputException, NoSuchMethodException {
        checkInputSize();
        String ctorArg = getPieceAndCommand()[1];
        Piece piece = null;
        try {
            piece = (Piece) PieceType.getInstanceOf(getPieceAndCommand()[0])
                    .getConstructor(String.class)
                    .newInstance(new Object[]{ctorArg});
        } catch (InvocationTargetException e) {
            throw new InvalidInputException(e.getMessage());
        }
        List<Cell> availableSlots = piece.getAvailableSlots();
        StringBuffer output = new StringBuffer();
        for (Cell cell : availableSlots)
            output.append(cell.getLocation() + ", ");
        return output.substring(0, output.length() - 2);
    }

    private void checkInputSize() throws InvalidInputException {
        String[] commands = getPieceAndCommand();

        if (commands.length != 2 || commands[1].length() != 2)
            throw new InvalidInputException(input + " is not a valid move");
    }

    private String[] getPieceAndCommand() {
        return input.trim().split(" ");
    }
}
