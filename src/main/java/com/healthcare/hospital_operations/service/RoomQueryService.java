package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.RoomResponseDto;

import java.util.List;

public interface RoomQueryService {

    /**
     *
     * @return a list of all rooms
     */
    List<RoomResponseDto> getAllRooms();
}
