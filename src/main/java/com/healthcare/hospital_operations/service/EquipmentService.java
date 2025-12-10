package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.dto.EquipmentResponseDto;

import java.util.List;

public interface EquipmentService {

    /**
     * This function is responsible for adding new equipment;
     * @param requestDto
     * @return equipment details
     */
    EquipmentResponseDto newEquipment(EquipmentRequestDto requestDto);

    /**
     * This method returns all equipments in the system.
     * @return
     */
    List<EquipmentResponseDto> getAllEquipments();
}
