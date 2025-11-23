package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.model.AllocationRequest;

import java.util.List;

public interface AllocationRequestQuery {
    /**
     * This method returns all existing allocation requests
     * @return
     */
    List<AllocationRequest> getAllRequests();
}
