package com.healthcare.hospital_operations.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class EquipmentExceptionController {

    @ExceptionHandler(EquipmentAlreadyExistsException.class)
    public ResponseEntity<?> handleEquipmentAlreadyExists(EquipmentAlreadyExistsException ex){
        return
                ResponseEntity
                        .status(409)
                        .body(Map.of("message",String.format("%s%s","",ex.getMessage())));
    }
}

