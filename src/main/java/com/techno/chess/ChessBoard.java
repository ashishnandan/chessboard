package com.techno.chess;

import com.techno.chess.pieces.PieceType;

import java.util.Arrays;

public class ChessBoard {

    private final Character[] xAxis = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private final int[] yAxis = {1, 2, 3, 4, 5, 6, 7, 8};

    public boolean isValidInput(String input) {
        String[] commands = input.trim().split(" ");

        if (commands.length != 2 || !PieceType.isValid(commands[0]) || commands[1].length() != 2)
            return false;

        boolean xAxisPositionInRange =
                Arrays.stream(xAxis).anyMatch(character -> character.equals(Character.toUpperCase(commands[1].charAt(0))));
        boolean yAxisPositionInRange =
                Arrays.stream(yAxis).anyMatch(num -> Integer.parseInt(String.valueOf(commands[1].charAt(1))) == num);
        return xAxisPositionInRange && yAxisPositionInRange;
    }


    public String getAvailableSlots() {
        return "work in progress";
    }
}
