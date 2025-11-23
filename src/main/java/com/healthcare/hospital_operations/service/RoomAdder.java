package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.model.Room;

public interface RoomAdder {
    /**
     *
     * @param roomType
     * @return
     */
    boolean supports(String roomType);

    /**
     *
     * @param requestDto
     * @return
     */
    Room add(String type, NewRoomRequestDto requestDto);
}
