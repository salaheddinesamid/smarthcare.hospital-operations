package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomStatus;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomResponseDto newRoom(NewRoomRequestDto requestDto) {
        Integer roomNumber = requestDto.getRoomNumber();
        Integer floorNumber = requestDto.getFloorNumber();
        // Check if the room already exists by number and floor:
        if(roomRepository.existsByRoomNumberAndFloorNumber(roomNumber,floorNumber)){
            throw new RoomAlreadyExistsException(floorNumber.toString());
        }

        // Otherwise:
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setFloorNumber(floorNumber);
        room.setAvailableIn(LocalDateTime.now());
        room.setCapacity(requestDto.getCapacity());
        room.setAvailablePlaces(requestDto.getCapacity());
        room.setStatus(RoomStatus.AVAILABLE);

        // save the room:
        Room savedRoom = roomRepository.save(room);

        return new RoomResponseDto(savedRoom);
    }
}
