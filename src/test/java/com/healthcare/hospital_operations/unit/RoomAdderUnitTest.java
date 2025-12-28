package com.healthcare.hospital_operations.unit;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.implementation.DefaultRoomAdderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RoomAdderUnitTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private DefaultRoomAdderImpl roomAdder;

    private Equipment equipment;
    private Room existingRoom;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        // Mock the equipment
        equipment = new Equipment();
        equipment.setEquipmentId(1L);
        equipment.setSerialNumber("EQ123");

        // Mock an existing room:
        existingRoom = new Room();
        existingRoom.setRoomId(1L);
    }

    @Test
    void testAddDefaultRoomSuccess(){
        // Mock the request dto:
        NewRoomRequestDto requestDto = new NewRoomRequestDto(
                120,
                3,
                4,
                "GENERAL",
                List.of(1L),
                4,
                "AVAILABLE",
                LocalDateTime.now()
        );

        // Arrange:
        when(equipmentRepository.findAllById(List.of(1L))).thenReturn(List.of(equipment));
        // Act:
        roomAdder.add("GENERAL",requestDto);
        // Verify:
        verify(roomRepository, times(1)).save(any());
    }

    @Test
    void testAddDefaultRoomThrowRoomAlreadyExists(){
        // Mock the request dto:
        NewRoomRequestDto requestDto = new NewRoomRequestDto(
                120,
                3,
                4,
                "GENERAL",
                List.of(1L),
                4,
                "AVAILABLE",
                LocalDateTime.now()
        );
        // Arrange:
        when(equipmentRepository.findAllById(List.of(1L))).thenReturn(List.of(equipment));
        when(roomRepository.existsByRoomNumberAndFloorNumber(120,3)).thenReturn(true);
        when(roomRepository.findById(1L)).thenReturn(Optional.of(existingRoom));

        // Act and assert:
        assertThrows(RoomAlreadyExistsException.class, ()-> roomAdder.add("GENERAL",requestDto));
    }
}
