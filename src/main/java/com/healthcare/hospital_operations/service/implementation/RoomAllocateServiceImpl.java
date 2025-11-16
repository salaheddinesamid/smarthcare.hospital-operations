package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.AllocationDetailsResponseDto;
import com.healthcare.hospital_operations.dto.AllocationRequestDto;
import com.healthcare.hospital_operations.dto.PatientDetails;
import com.healthcare.hospital_operations.exception.RoomUnavailableException;
import com.healthcare.hospital_operations.model.Allocation;
import com.healthcare.hospital_operations.model.AllocationPriority;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomStatus;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoomAllocateServiceImpl implements RoomAllocateService {

    private final RoomRepository roomRepository;
    private final PatientServiceClientImpl patientServiceClient;

    @Autowired
    public RoomAllocateServiceImpl(RoomRepository roomRepository, PatientServiceClientImpl patientServiceClient) {
        this.roomRepository = roomRepository;
        this.patientServiceClient = patientServiceClient;
    }

    @Override
    public AllocationDetailsResponseDto allocate(Long roomId, Integer patientId, AllocationRequestDto request) {
        /*
        // Fetch room from db:
        Room room =
                roomRepository.findById(roomId).orElseThrow();

        // Check room availability:
        if(!room.getStatus().equals(RoomStatus.AVAILABLE)){
            throw new RoomUnavailableException(room.getRoomId().toString());
        }

        // Check equipments availability based on the issue:

        // Otherwise:
        // Get patient details:
        PatientDetails patient = patientServiceClient.getPatient(patientId);

        Allocation allocation = new Allocation();
        allocation.setAllocationDate(LocalDateTime.now());
        allocation.setPatientId(patientId);
        allocation.setPriority(AllocationPriority.valueOf(requestDto.getPriority()));
        allocation.setRemarks(requestDto.getRemarks());
        allocation.setRoom(room);
        // Update room available places:
        room.setAvailablePlaces(room.getAvailablePlaces() - 1);

        // save the allocation:
        // save the room:

         */

        return null;
    }
}
