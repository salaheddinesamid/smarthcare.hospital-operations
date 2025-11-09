package com.healthcare.hospital_operations.repository;

import com.healthcare.hospital_operations.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Long> {
}
