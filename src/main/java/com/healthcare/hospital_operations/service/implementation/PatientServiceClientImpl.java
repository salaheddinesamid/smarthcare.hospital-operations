package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.PatientDetails;
import com.healthcare.hospital_operations.service.PatientServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientServiceClientImpl implements PatientServiceClient {

    @Value("${services.patient}")
    private String PATIENT_SERVICE;

    private final RestTemplate restTemplate;

    public PatientServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public PatientDetails getPatient(Integer patientId) {
        String URI = String.format("%s%s%s",PATIENT_SERVICE,"/api/patient-management/get?patientId=",patientId);
        ResponseEntity<PatientDetails> response =
                restTemplate.exchange(
                        URI,
                        HttpMethod.GET,
                        null,
                        PatientDetails.class
                );

        return response.getBody();
    }
}
