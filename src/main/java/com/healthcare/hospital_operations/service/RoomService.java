package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;

public interface RoomService {

    /**
     * This function adds new room to the system
     * @param requestDto
     * @return
     */
    RoomResponseDto newRoom(String type, NewRoomRequestDto requestDto);
}
