package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;

public interface AllocationService {
    /**
     *
     * @param requestDto
     * @return
     */
    AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDto);
}
