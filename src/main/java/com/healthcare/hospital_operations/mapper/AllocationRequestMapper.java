package com.healthcare.hospital_operations.mapper;

import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.model.AllocationPriority;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.model.RoomType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AllocationRequestMapper {

    public AllocationRequest mapToAllocationRequest(
            RoomAllocationRequestDto requestDetails
    ){
        AllocationRequest allocationRequest  = new AllocationRequest();
        allocationRequest.setAllocationPriority(AllocationPriority.valueOf(requestDetails.getPriority()));
        allocationRequest.setRoomType(RoomType.valueOf(requestDetails.getRoomType()));
        allocationRequest.setRequestDate(LocalDateTime.now());
        allocationRequest.setSymptoms(requestDetails.getSymptoms());
        allocationRequest.setFrom(requestDetails.getFrom());
        allocationRequest.setTo(requestDetails.getTo());
        return allocationRequest;
    }
}
