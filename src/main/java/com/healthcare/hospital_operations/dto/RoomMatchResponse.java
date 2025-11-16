package com.healthcare.hospital_operations.dto;

import com.healthcare.hospital_operations.model.Room;
import lombok.Data;

@Data
public class RoomMatchResponse {
    private Long roomID;
    private String roomType;
    private Integer floor;
    private Integer roomNumber;
    private Integer score;

    public RoomMatchResponse(
            Room room,
            Integer score
    ){
        this.roomID = room.getRoomId();
        this.roomType = room.getRoomType().toString();
        this.floor = room.getFloorNumber();
        this.roomNumber = room.getRoomNumber();
        this.score = score;
    }
}
