package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.model.Equipment;

public interface EquipmentMapper {

    /**
     * This function helps to validate all request fields
     * @param requestDto
     */
    void validate(EquipmentRequestDto requestDto);

    /**
     *
     * @param requestDto
     * @return
     */
    Equipment mapToEquipment(EquipmentRequestDto requestDto);
}
