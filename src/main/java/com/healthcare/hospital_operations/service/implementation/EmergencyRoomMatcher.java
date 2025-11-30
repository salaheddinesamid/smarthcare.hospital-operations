package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.RoomMatchResponse;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.service.RoomMatcher;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmergencyRoomMatcher implements RoomMatcher {
    @Override
    public List<RoomMatchResponse> generateMatches(AllocationRequest request) {
        return List.of();
    }
}
