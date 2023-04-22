package com.gama.exception;

public class InvalidPayloadException extends RuntimeException {

    public InvalidPayloadException (String message) {
        super("invalid payload");
    }
}
