package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.EquipmentResponseDto;
import com.healthcare.hospital_operations.model.Equipment;

import java.util.List;

public interface EquipmentQueryService {

    List<EquipmentResponseDto> getAll();
}
