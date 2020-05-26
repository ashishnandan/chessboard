package com.techno.chess.exception;

public class InvalidInputException extends Throwable {
    public InvalidInputException(String s) {
        super(s);
    }

    public InvalidInputException(Exception e) {
        super(e);
    }
}
