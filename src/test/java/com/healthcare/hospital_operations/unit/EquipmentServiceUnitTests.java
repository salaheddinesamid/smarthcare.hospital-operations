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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EquipmentServiceUnitTests {

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private EquipmentMapperImpl equipmentMapper;

    @InjectMocks
    private DefaultEquipmentAdderServiceImpl defaultEquipmentAdderService;

    private Equipment existedEquipment;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        existedEquipment = new Equipment();
        existedEquipment.setEquipmentId(1L);
        existedEquipment.setSerialNumber("SER20930");
        existedEquipment.setModelNumber("");
    }

    @Test
    void testAddNewEquipmentSuccess(){
        // Arrange request:
        EquipmentRequestDto request  = new EquipmentRequestDto();
        // Act:
        defaultEquipmentAdderService.add(request);
        // Verify:
        verify(equipmentRepository,times(1)).save(any());
    }

    @Test
    void testAddNewEquipmentThrowEquipmentAlreadyException(){

        // Arrange request:
        when(equipmentRepository.existsBySerialNumber("SER20930")).thenReturn(true);
        EquipmentRequestDto request  = new EquipmentRequestDto();
        request.setSerialNumber("SER20930");

        // Act & Verify:
        assertThrows(EquipmentAlreadyExistsException.class, ()-> defaultEquipmentAdderService.add(request));
    }
}
