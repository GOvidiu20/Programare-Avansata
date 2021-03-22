package com.company.clase;

public class InvalidFileException extends RuntimeException {

    public InvalidFileException(String param) {
        super("Invalid path: " + param);
    }
}