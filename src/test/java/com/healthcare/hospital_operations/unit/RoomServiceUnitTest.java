package com.healthcare.hospital_operations.unit;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomStatus;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.implementation.DefaultRoomAdderImpl;
import com.healthcare.hospital_operations.service.implementation.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomServiceUnitTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private DefaultRoomAdderImpl defaultRoomAdder;

    @InjectMocks
    private RoomServiceImpl roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddGeneralRoomSuccess(){
        // Arrange request:
        NewRoomRequestDto requestDto = new NewRoomRequestDto();
        requestDto.setCapacity(2);
        requestDto.setEquipments(List.of());
        requestDto.setFloorNumber(4);
        requestDto.setRoomNumber(203);
        requestDto.setRoomType("GENERAL");

        when(roomRepository.existsByRoomNumberAndFloorNumber(4,203)).thenReturn(false);
        when(equipmentRepository.findAllById(requestDto.getEquipments())).thenReturn(List.of());
        // Act:
        defaultRoomAdder.add("GENERAL",requestDto);
        // Verify:
        verify(roomRepository, times(1)).save(any());
    }

    @Test
    void newRoom_ShouldThrowException_WhenRoomAlreadyExists() {
        // Arrange
        NewRoomRequestDto requestDto = new NewRoomRequestDto();
        requestDto.setRoomNumber(101);
        requestDto.setFloorNumber(2);
        requestDto.setCapacity(4);

        when(roomRepository.existsByRoomNumberAndFloorNumber(101, 2)).thenReturn(true);

        // Act + Assert
        RoomAlreadyExistsException exception =
                assertThrows(RoomAlreadyExistsException.class, () -> roomService.newRoom("GENERAL",requestDto));

        assertEquals("2", exception.getMessage());
        verify(roomRepository, never()).save(any(Room.class));
    }

    @Test
    void newRoom_ShouldCreateRoomSuccessfully_WhenRoomDoesNotExist() {
        // Arrange
        NewRoomRequestDto requestDto = new NewRoomRequestDto();
        requestDto.setRoomNumber(101);
        requestDto.setFloorNumber(2);
        requestDto.setCapacity(4);

        when(roomRepository.existsByRoomNumberAndFloorNumber(101, 2)).thenReturn(false);

        Room roomToSave = new Room();
        roomToSave.setRoomNumber(101);
        roomToSave.setFloorNumber(2);
        roomToSave.setCapacity(4);
        roomToSave.setAvailablePlaces(4);
        roomToSave.setStatus(RoomStatus.AVAILABLE);
        roomToSave.setAvailableIn(LocalDateTime.now());

        Room savedRoom = new Room();
        savedRoom.setRoomId(1L);
        savedRoom.setRoomNumber(101);
        savedRoom.setFloorNumber(2);
        savedRoom.setCapacity(4);
        savedRoom.setAvailablePlaces(4);
        savedRoom.setStatus(RoomStatus.AVAILABLE);

        when(roomRepository.save(any(Room.class))).thenReturn(savedRoom);

        // Act
        RoomResponseDto response = roomService.newRoom("GENERAL",requestDto);

        // Assert
        assertNotNull(response);
        assertEquals(101, response.getRoomNumber());
        assertEquals(2, response.getFloorNumber());
        assertEquals(4, response.getCapacity());

        // Verify save was called with correct properties
        ArgumentCaptor<Room> roomCaptor = ArgumentCaptor.forClass(Room.class);
        verify(roomRepository).save(roomCaptor.capture());

        // verify the saved values:
        Room capturedRoom = roomCaptor.getValue();
        assertEquals(101, capturedRoom.getRoomNumber());
        assertEquals(2, capturedRoom.getFloorNumber());
        assertEquals(4, capturedRoom.getCapacity());
        assertEquals(4, capturedRoom.getAvailablePlaces());
        assertEquals(RoomStatus.AVAILABLE, capturedRoom.getStatus());
    }
}
