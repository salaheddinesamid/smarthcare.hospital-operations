package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.AllocationDetailsResponseDto;
import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;

public interface RoomAllocationService {
    /**
     *
     * @param type
     * @return
     */
    boolean supports(String type);

    /**
     *
     * @param requestDetails
     * @return
     */
    AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDetails);
}
