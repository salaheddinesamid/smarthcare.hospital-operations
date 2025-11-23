package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.ApiResponse;
import com.healthcare.hospital_operations.dto.PatientDetails;
import com.healthcare.hospital_operations.service.PatientServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
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

    @Override
    public List<PatientDetails> getPatients(List<Integer> ids) {
        String uri = PATIENT_SERVICE + "/api/patient-management/get-patients";
        HttpEntity<List<Integer>> entity = new HttpEntity<>(ids);

        log.info("Fetching patients from service: {}",uri);
        ResponseEntity<ApiResponse<List<PatientDetails>>> response =
                restTemplate.exchange(
                        uri,
                        HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<>() {
                        }
                );

        return response.getBody().getData();
    }
}
