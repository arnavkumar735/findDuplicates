package com.example.demo.exception;

public class ReadFileErrorException extends RuntimeException {
    public ReadFileErrorException(String message) {
        super(message);
    }
}

