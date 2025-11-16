package com.healthcare.hospital_operations.dto;

import com.healthcare.hospital_operations.model.Allocation;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class AllocationDetailsResponseDto {

    private Long id;
    private LocalDateTime admissionDate;
    private PatientDetails patientDetails;
    private String issue;
    private String priority;
    private String status;

    public AllocationDetailsResponseDto(Allocation allocation,PatientDetails patient){
        this.id = allocation.getAllocationId();
        this.admissionDate = allocation.getAllocationDate();
        this.patientDetails = patient;
        this.issue = allocation.getIssue();
        this.priority = allocation.getPriority().name();
        this.status = allocation.getStatus().name();
    }
}
