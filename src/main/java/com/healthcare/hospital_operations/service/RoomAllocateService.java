package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.AllocationDetailsResponseDto;
import com.healthcare.hospital_operations.dto.AllocationRequestDto;

public interface RoomAllocateService {

    AllocationDetailsResponseDto allocate(Long roomId, Integer patientId ,AllocationRequestDto request);
}
