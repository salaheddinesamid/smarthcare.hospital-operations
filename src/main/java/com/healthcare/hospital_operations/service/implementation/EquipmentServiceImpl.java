package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.dto.EquipmentResponseDto;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final DefaultEquipmentAdderServiceImpl defaultEquipmentAdderService;

    @Autowired
    public EquipmentServiceImpl(DefaultEquipmentAdderServiceImpl defaultEquipmentAdderService) {
        this.defaultEquipmentAdderService = defaultEquipmentAdderService;
    }

    @Override
    public EquipmentResponseDto newEquipment(EquipmentRequestDto requestDto) {
        // Act:
        Equipment equipment = defaultEquipmentAdderService.add(requestDto);
        // Return a response dto for the saved equipment
        return new EquipmentResponseDto(equipment);
    }
}
