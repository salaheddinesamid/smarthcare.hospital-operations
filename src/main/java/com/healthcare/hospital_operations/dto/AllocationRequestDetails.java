package com.healthcare.hospital_operations.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllocationRequestDetails {
    private Long requestId;
    private LocalDateTime requestDate;
    private String priority;
    private String symptoms;
    private String roomType;
    private PatientDetails patientDetails;
    public AllocationRequestDetails(PatientDetails patientDetails){
        this.patientDetails = patientDetails;
    }
}
