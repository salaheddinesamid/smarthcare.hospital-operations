package com.healthcare.hospital_operations.unit;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.implementation.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RoomServiceUnitTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomServiceImpl roomService;

    private Room room;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        room = new Room();
        room.setRoomId(1L);
        room.setRoomNumber(202);
        room.setFloorNumber(4);
        room.setCapacity(3);
    }

    @Test
    void testAddRoomSuccess(){
        // Build request dto:
        NewRoomRequestDto request = new NewRoomRequestDto();
        request.setRoomNumber(200);
        request.setFloorNumber(4);
        request.setCapacity(3);

        // Arrange:
        when(roomRepository.existsByRoomNumberAndFloorNumber(request.getRoomNumber(), room.getFloorNumber())).thenReturn(false);

        // Act:
        RoomResponseDto response =  roomService.newRoom(request);
        verify(roomRepository, times(1)).save(any());



    }

    @Test
    void testAddRoomThrowRoomAlreadyExists(){
        // Build request dto:
        NewRoomRequestDto request = new NewRoomRequestDto();
        request.setRoomNumber(202);
        request.setFloorNumber(4);

        // Arrange:
        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));
        when(roomRepository.existsByRoomNumberAndFloorNumber(request.getRoomNumber(), room.getFloorNumber())).thenReturn(true);

        // Act:
        assertThrows(RoomAlreadyExistsException.class, ()-> roomService.newRoom(request));
    }
}
