package com.healthcare.hospital_operations.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewRoomRequestDto {
    private Integer roomNumber;
    private Integer floorNumber;
    private Integer capacity;
    private Integer availablePlaces;
    private String status;
    private LocalDateTime availableIn;
}
