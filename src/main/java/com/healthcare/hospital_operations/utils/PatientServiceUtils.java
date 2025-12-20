package com.healthcare.hospital_operations.utils;

import com.healthcare.hospital_operations.dto.PatientDetails;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientServiceUtils {

    private final RestTemplate restTemplate;
    private final static String PATIENT_SERVICE_URI = "";

    public PatientServiceUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     *  Fetch patient details from PATIENT SERVICE.
     * @param nationalId
     * @return
     */
    public PatientDetails fetchPatientDetails(String nationalId){
        String uri = PATIENT_SERVICE_URI + "/api/patient-management";
        ResponseEntity<PatientDetails> response =
                restTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        PatientDetails.class
                );

        return response.getBody();
    }
}
