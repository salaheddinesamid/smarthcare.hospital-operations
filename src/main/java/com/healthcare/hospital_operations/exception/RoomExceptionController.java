package com.healthcare.hospital_operations.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RoomExceptionController {

    @ExceptionHandler(RoomAlreadyExistsException.class)
    public ResponseEntity<?> handleRoomAlreadyExistsException(
            RoomAlreadyExistsException ex
    ){
        return
                ResponseEntity
                        .status(409)
                        .body(
                                Map.of("message",String.format("%s%s","The room is already in the system: ", ex.getMessage()))
                        );
    }
}
