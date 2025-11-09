package com.healthcare.hospital_operations.dto;

import com.healthcare.hospital_operations.model.Room;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomResponseDto {

    private Long roomId;
    private Integer roomNumber;
    private Integer floorNumber;
    private Integer capacity;
    private Integer availablePlaces;
    private String status;
    private LocalDateTime availableIn;

    public RoomResponseDto(Room room){
        this.roomId = room.getRoomId();
        this.roomNumber = room.getRoomNumber();
        this.floorNumber = room.getFloorNumber();
        this.capacity = room.getAvailablePlaces();
        this.availablePlaces = room.getAvailablePlaces();
        this.status = room.getStatus().toString();
        this.availableIn = room.getAvailableIn();
    }
}
