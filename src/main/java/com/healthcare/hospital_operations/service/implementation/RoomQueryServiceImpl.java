package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomQueryServiceImpl implements RoomQueryService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomQueryServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomResponseDto> getAllRooms() {
        // fetch the rooms from db:
        List<Room> rooms = roomRepository.findAll();
        // return a mapped response
        return rooms
                .stream().map(RoomResponseDto::new)
                .toList();
    }
}
