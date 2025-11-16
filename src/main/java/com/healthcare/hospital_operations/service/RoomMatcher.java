package com.healthcare.hospital_operations.service;

import com.healthcare.hospital_operations.dto.RoomMatchResponse;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.model.Room;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This interface handles and generates best room matches for a specific allocation details (equipments, availability...)
 */
public interface RoomMatcher {

    /**
     * This method is responsible for generating the best matches
     * @return
     */
    List<RoomMatchResponse> generateMatches(AllocationRequest request);
}
