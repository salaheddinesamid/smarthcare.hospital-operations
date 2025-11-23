package com.healthcare.hospital_operations.repository;

import com.healthcare.hospital_operations.model.AllocationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRequestRepository extends JpaRepository<AllocationRequest, Long> {
}
