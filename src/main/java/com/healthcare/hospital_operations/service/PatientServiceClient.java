package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.PatientDetails;

public interface PatientServiceClient {
    /**
     * This function fetches patient details from the Patient Service
     * @param patientId
     * @return patient details
     */
    PatientDetails getPatient(Integer patientId);
}
