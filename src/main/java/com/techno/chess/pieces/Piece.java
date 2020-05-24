package com.techno.chess.pieces;

import com.techno.chess.Cell;

import java.util.List;

public interface Piece {

    List<Cell> getAvailableSlots(Cell start);
}
