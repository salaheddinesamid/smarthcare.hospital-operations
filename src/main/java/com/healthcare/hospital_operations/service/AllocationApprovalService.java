package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.AllocationDetailsResponseDto;

public interface AllocationApprovalService {

    /**
     * This function approves allocation requests made by patients
     * @param requestId
     * @return
     */
    AllocationDetailsResponseDto approveAllocationRequest(Long requestId);
}
