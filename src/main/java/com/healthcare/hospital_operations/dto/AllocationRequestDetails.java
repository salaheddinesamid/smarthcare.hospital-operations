package com.healthcare.hospital_operations.dto;

import com.healthcare.hospital_operations.model.AllocationRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllocationRequestDetails {
    private Long requestId;
    private LocalDateTime requestDate;
    private String priority;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String symptoms;
    private String roomType;
    private PatientDetails patientDetails;


    public AllocationRequestDetails(PatientDetails patientDetails, AllocationRequest allocationRequest){
        this.requestId = allocationRequest.getRequestId();
        this.requestDate = allocationRequest.getRequestDate();
        this.priority = allocationRequest.getRoomType().name();
        this.fromDate = allocationRequest.getFrom();
        this.toDate = allocationRequest.getTo();
        this.symptoms = allocationRequest.getSymptoms();
        this.patientDetails = patientDetails;

    }
}
