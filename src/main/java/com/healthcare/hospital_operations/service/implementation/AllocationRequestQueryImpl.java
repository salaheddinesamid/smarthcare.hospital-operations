package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.repository.AllocationRequestRepository;
import com.healthcare.hospital_operations.service.AllocationRequestQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllocationRequestQueryImpl implements AllocationRequestQuery {
    private final AllocationRequestRepository allocationRequestRepository;

    public AllocationRequestQueryImpl(AllocationRequestRepository allocationRequestRepository) {
        this.allocationRequestRepository = allocationRequestRepository;
    }

    @Override
    public List<AllocationRequest> getAllRequests() {
        return allocationRequestRepository.findAll();
    }
}
