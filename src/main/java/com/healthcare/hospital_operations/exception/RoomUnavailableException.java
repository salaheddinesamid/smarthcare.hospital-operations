package com.healthcare.hospital_operations.exception;

public class RoomUnavailableException extends RuntimeException{
    public RoomUnavailableException(String message) {
        super(message);
    }
}
