package com.sejong.recycle.board.exception;

public class AccessDenyException extends RuntimeException{
    public AccessDenyException(String message) {
        super(message);
    }
}
