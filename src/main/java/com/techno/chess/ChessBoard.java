package com.techno.chess;

import com.techno.chess.exception.InvalidInputException;
import com.techno.chess.pieces.Pawn;
import com.techno.chess.pieces.Piece;
import com.techno.chess.pieces.PieceType;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.techno.chess.constants.Constants.*;
import static com.techno.chess.constants.ExceptionConstants.INVALID_MOVE_MESSAGE;

public class ChessBoard {

    public final List<Piece> pieces = new ArrayList<>();
    private String input;
    private String[] inputArr;

    public ChessBoard(String input) {
        this.input = input;
    }

    public String getAvailableMoves() throws InvalidInputException {
        checkInput();
        Piece piece = PieceType.getInstance(extractPieceInfo(), String.class, extractMoveInfo());
        pieces.add(piece);
        List<Cell> availableSlots = piece.getAvailableSlots();

        // check if pawn is allowed to move diagonally
        if (piece instanceof Pawn) {
            Pawn pawn = (Pawn) piece;
            availableSlots.addAll(pawn.addDiagonalSlotsOfPawn(pieces));
        }

        return availableSlots.toString().replace(OPENING_BRACE, EMPTY_STRING).replace(CLOSING_BRACE, EMPTY_STRING).trim();
    }

    private void checkInput() throws InvalidInputException {
        inputArr = input.split(REGEX);
        if (inputArr.length != MAX_LENGTH || extractMoveInfo().length() != MAX_LENGTH) {
            throw new InvalidInputException(MessageFormat.format(INVALID_MOVE_MESSAGE, input));
        }
    }

    private String extractPieceInfo() {
        return inputArr[0];
    }

    private String extractMoveInfo() {
        return inputArr[1];
    }
}
