package com.healthcare.hospital_operations.unit;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.exception.EquipmentAlreadyExistsException;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.service.implementation.DefaultEquipmentAdderServiceImpl;
import com.healthcare.hospital_operations.service.implementation.EquipmentMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EquipmentAdderUnitTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private EquipmentMapperImpl equipmentMapper;

    @InjectMocks
    private DefaultEquipmentAdderServiceImpl defaultEquipmentAdderService;

    private Equipment existingEquipment;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        existingEquipment = new Equipment();
        existingEquipment.setSerialNumber("DDSS23300");
        existingEquipment.setEquipmentId(1L);
    }

    /**
     *
     */
    @Test
    void testAddEquipmentSuccess(){
        // Mock the request dto:
        EquipmentRequestDto equipmentRequestDto = new EquipmentRequestDto(
                "test",
                "CCDL2910",
                "MANUFACTURER",
                "XXCC30",
                LocalDate.of(2024, 10, 3),
                LocalDate.of(2030, 10, 4),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 1, 3),
                "GOOD"
        );

        // Arrange:
        when(equipmentRepository.existsBySerialNumber("XXCC30")).thenReturn(false);

        // Act & Verify:
        defaultEquipmentAdderService.add(equipmentRequestDto);
        verify(equipmentRepository, times(1)).save(any());
    }

    /**
     *
     */
    @Test
    void addEquipmentAlreadyExists(){
        // Mock the request dto:
        EquipmentRequestDto equipmentRequestDto = new EquipmentRequestDto(
                "test",
                "CCDL2910",
                "MANUFACTURER",
                "XXCC30",
                LocalDate.of(2024, 10, 3),
                LocalDate.of(2030, 10, 4),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 1, 3),
                "GOOD"
        );

        // Arrange:
        when(equipmentRepository.existsBySerialNumber("XXCC30")).thenReturn(true);

        // Act & assert:
        assertThrows(EquipmentAlreadyExistsException.class, ()-> defaultEquipmentAdderService.add(equipmentRequestDto));
    }
}
