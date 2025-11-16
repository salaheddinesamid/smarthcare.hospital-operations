package com.healthcare.hospital_operations.exception;

public class EquipmentAlreadyExistsException extends RuntimeException{

    public EquipmentAlreadyExistsException(String message) {
        super(message);
    }
}
