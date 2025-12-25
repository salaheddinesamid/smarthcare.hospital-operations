package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.model.AllocationType;
import com.healthcare.hospital_operations.service.RoomAllocationService;
import org.springframework.stereotype.Service;

@Service
public class EmergencyRoomAllocationService implements RoomAllocationService {
    @Override
    public boolean supports(String type) {
        return
                AllocationType.EMERGENCY.equals(AllocationType.valueOf(type));
    }

    @Override
    public AllocationRequestDetails requestAllocation(RoomAllocationRequestDto requestDetails) {
        return null;
    }
}
