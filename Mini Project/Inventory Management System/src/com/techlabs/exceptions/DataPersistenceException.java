package com.techlabs.exceptions;

public class DataPersistenceException extends RuntimeException{
    public DataPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
