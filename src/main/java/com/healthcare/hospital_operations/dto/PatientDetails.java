package com.healthcare.hospital_operations.dto;

import lombok.Data;

@Data
public class PatientDetails {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Integer patientId;
    private String nationalId;
    private String address;
    private String status;
}
