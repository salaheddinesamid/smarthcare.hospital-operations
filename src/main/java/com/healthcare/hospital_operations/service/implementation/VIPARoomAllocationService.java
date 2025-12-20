package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.PatientDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.service.RoomAllocationService;
import com.healthcare.hospital_operations.utils.PatientServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VIPARoomAllocationService implements RoomAllocationService {

    private final PatientServiceUtils patientServiceUtils;

    @Autowired
    public VIPARoomAllocationService(PatientServiceUtils patientServiceUtils) {
        this.patientServiceUtils = patientServiceUtils;
    }

    @Override
    public boolean supports(String type) {
        return false;
    }

    @Override
        public AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDetails) {
        // fetch the patient details:
        PatientDetails patientDetails =
                patientServiceUtils.fetchPatientDetails(requestDetails.getNationalId());

        // map the request dto to allocation request object:
        //AllocationRequest allocationRequest =
        return null;
    }
}
