package com.techno.chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ChessBoardTest {

    private ChessBoard chessBoard;

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
    }

    @Test
    public void isValidInput() {
        String[] validInputs = {"King D5", "Queen C6", "rook a7 ", " queen b2 "};
        Arrays.stream(validInputs).map(validInput -> chessBoard.isValidInput(validInput)).forEach(Assert::assertTrue);
        String [] invalidInputs = {"Kin f6", "Queen a8 b8", "Rook f", "C6"};
        Arrays.stream(invalidInputs).map(input -> chessBoard.isValidInput(input)).forEach(Assert::assertFalse);
    }

    @Test
    public void getAvailableSlots() {
    }
}