package com.example.demo.exception;

public class NoDuplicatesFoundException extends RuntimeException {
    public NoDuplicatesFoundException(String message) {
        super(message);
    }
}
