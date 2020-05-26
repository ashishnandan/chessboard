package com.techno.chess.move;

import com.techno.chess.Cell;

public enum HorseMovementDirection {
    TOP_RIGHT{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveUp();
            newCell = newCell.moveUp();
            return newCell.moveRight();
        }
    }, SIDE_RIGHT_TOP{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveRight();
            newCell = newCell.moveRight();
            return newCell.moveUp();
        }
    }, SIDE_RIGHT_BOTTOM{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveRight();
            newCell = newCell.moveRight();
            return newCell.moveDown();
        }
    }, BOTTOM_RIGHT{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveDown();
            newCell = newCell.moveDown();
            return newCell.moveRight();
        }
    }, BOTTOM_LEFT{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveDown();
            newCell = newCell.moveDown();
            return newCell.moveLeft();
        }
    }, SIDE_LEFT_BOTTOM{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveLeft();
            newCell = newCell.moveLeft();
            return newCell.moveDown();
        }
    }, SIDE_LEFT_TOP{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveLeft();
            newCell = newCell.moveLeft();
            return newCell.moveUp();
        }
    }, TOP_LEFT{
        @Override
        public Cell move(Cell start) {
            Cell newCell = start;
            newCell = newCell.moveUp();
            newCell = newCell.moveUp();
            return newCell.moveLeft();
        }
    };


    public abstract Cell move(Cell start);
}
