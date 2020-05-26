package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.pieces.Pawn;
import com.techno.chess.pieces.Piece;
import com.techno.chess.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private String input;

    private static final String REGEX = " ";

    public ChessBoard(String input) {
        this.input = input;
    }

    private String[] inputArr;

    public final List<Piece> pieces = new ArrayList<>();

    public String getAvailableMoves() throws InvalidInputException {
        checkInput();
        Piece piece = PieceType.getInstance(extractPieceInfo(), String.class, extractMoveInfo());
        pieces.add(piece);
        List<Cell> availableSlots = piece.getAvailableSlots();

        // check if pawn is allowed to move diagonally
        if (piece instanceof Pawn)
        {
            Pawn pawn = (Pawn) piece;
            availableSlots.addAll(pawn.addDiagonalSlotsOfPawn(pieces));
        }


        StringBuilder output = new StringBuilder();
        availableSlots.stream().map(cell -> cell.getLocation() + ", ").forEach(output::append);
        return output.length() == 0 ? output.toString() : output.substring(0, output.length() - 2);
    }

    private void checkInput() throws InvalidInputException {
        inputArr = input.split(REGEX);
        if (inputArr.length != 2 || extractMoveInfo().length() != 2) {
            throw new InvalidInputException(input + " is not a valid move");
        }
    }

    private String extractPieceInfo() {
        return inputArr[0];
    }

    private String extractMoveInfo() {
        return inputArr[1];
    }
}
