package com.healthcare.hospital_operations.exception;

public class RoomAlreadyExistsException extends RuntimeException{
    public RoomAlreadyExistsException(String message) {
        super(message);
    }
}
