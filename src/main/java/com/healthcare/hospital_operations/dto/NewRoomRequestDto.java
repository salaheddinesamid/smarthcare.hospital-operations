package com.healthcare.hospital_operations.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NewRoomRequestDto {
    private Integer roomNumber;
    private Integer floorNumber;
    private Integer capacity;
    private String roomType;
    private List<Long> equipments;
    private Integer availablePlaces;
    private String status;
    private LocalDateTime availableIn;
}
