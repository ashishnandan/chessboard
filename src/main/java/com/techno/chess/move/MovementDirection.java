package com.techno.chess.move;

import com.techno.chess.Cell;

public enum MovementDirection {

    VERTICAL_TOP{
        @Override
        public Cell move(Cell start) {
            return start.moveUp();
        }
    },
    DIAGONAL_TOP_RIGHT{
        @Override
        public Cell move(Cell start) {
            return start.moveUpDiagonalRight();
        }
    },
    HORIZONTAL_RIGHT{
        @Override
        public Cell move(Cell start) {
            return start.moveRight();
        }
    },
    DIAGONAL_BOTTOM_RIGHT{
        @Override
        public Cell move(Cell start) {
            return start.moveDownDiagonalRight();
        }
    },
    VERTICAL_BOTTOM{
        @Override
        public Cell move(Cell start) {
            return start.moveDown();
        }
    },
    DIAGONAL_BOTTOM_LEFT{
        @Override
        public Cell move(Cell start) {
            return start.moveDownDiagonalLeft();
        }
    },
    HORIZONTAL_LEFT{
        @Override
        public Cell move(Cell start) {
            return start.moveLeft();
        }
    },
    DIAGONAL_TOP_LEFT{
        @Override
        public Cell move(Cell start) {
            return start.moveUpDiagonalLeft();
        }
    };

    public abstract Cell move(Cell start);
}
