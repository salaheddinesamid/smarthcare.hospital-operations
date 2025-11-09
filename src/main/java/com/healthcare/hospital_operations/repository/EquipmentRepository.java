package com.healthcare.hospital_operations.repository;

import com.healthcare.hospital_operations.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
