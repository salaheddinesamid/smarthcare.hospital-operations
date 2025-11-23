package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomStatus;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomAdder;
import com.healthcare.hospital_operations.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final List<RoomAdder> roomAdders;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, List<RoomAdder> roomAdders) {
        this.roomRepository = roomRepository;
        this.roomAdders = roomAdders;
    }

    @Override
    public RoomResponseDto newRoom(String roomType, NewRoomRequestDto requestDto) {
        // validate if the adder supports the room type:
        RoomAdder adder =
                roomAdders.stream().filter(roomAdder -> roomAdder.supports(roomType))
                        .findFirst().orElseThrow();

        Room newRoom = adder.add(roomType, requestDto);
        return new RoomResponseDto(newRoom);
    }
}
