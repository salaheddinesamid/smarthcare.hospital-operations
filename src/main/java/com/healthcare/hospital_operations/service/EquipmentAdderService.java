package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.model.Equipment;

public interface EquipmentAdderService {
    /**
     *
     * @param requestDto
     */
    void validate(EquipmentRequestDto requestDto);

    /**
     *
     * @return
     */
    Equipment add(EquipmentRequestDto requestDto);
}
