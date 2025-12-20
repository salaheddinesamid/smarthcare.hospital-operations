package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.PatientDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.mapper.AllocationRequestMapper;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.model.RoomType;
import com.healthcare.hospital_operations.repository.AllocationRequestRepository;
import com.healthcare.hospital_operations.service.RoomAllocationService;
import com.healthcare.hospital_operations.utils.PatientServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoomAllocationService implements RoomAllocationService {

    private final AllocationRequestMapper allocationRequestMapper;
    private final AllocationRequestRepository allocationRequestRepository;
    private final PatientServiceUtils patientServiceUtils;

    @Autowired
    public DefaultRoomAllocationService(AllocationRequestMapper allocationRequestMapper, AllocationRequestRepository allocationRequestRepository, PatientServiceUtils patientServiceUtils) {
        this.allocationRequestMapper = allocationRequestMapper;
        this.allocationRequestRepository = allocationRequestRepository;
        this.patientServiceUtils = patientServiceUtils;
    }

    @Override
    public boolean supports(String type) {
        return RoomType.GENERAL.equals(RoomType.valueOf(type));
    }

    @Override
    public AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDetails) {
        // fetch the patient details:
        PatientDetails patientDetails =
                patientServiceUtils.fetchPatientDetails(requestDetails.getNationalId());

        // map the request dto to allocation request object:
        AllocationRequest allocationRequest = allocationRequestMapper
                .mapToAllocationRequest(requestDetails);

        allocationRequest.setPatientId(patientDetails.getPatientId());

        // save the request to the database:
        AllocationRequest savedRequest = allocationRequestRepository
                .save(allocationRequest);

        return new AllocationRequestDetails(
                patientDetails,
                savedRequest
        );
    }
}
