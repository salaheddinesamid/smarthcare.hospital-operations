package com.healthcare.hospital_operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
