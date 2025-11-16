package com.healthcare.hospital_operations.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllocationRequestDto {
    private String fullName;
    private String nationalId;
    private String issue;
    private String symptoms;
    private String details;
    private LocalDateTime allocationDate;
    private String priority;
    private String remarks;
}
