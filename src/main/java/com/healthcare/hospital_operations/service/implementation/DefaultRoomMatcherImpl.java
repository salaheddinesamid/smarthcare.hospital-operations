package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.RoomMatchResponse;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultRoomMatcherImpl implements RoomMatcher {

    private final RoomRepository roomRepository;

    @Autowired
    public DefaultRoomMatcherImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomMatchResponse> generateMatches(AllocationRequest request) {
        // fetch all rooms with specific type:
        List<Room> rooms = roomRepository
                .findAllByRoomType(request.getRoomType());
        List<RoomMatchResponse> matchResponse = new ArrayList<>();
        // Map contains rooms and their corresponding scores:
        Map<Integer,Room> roomScores = new HashMap<>();

        rooms
                .forEach(room -> {
                    int score = processRoomScore(room);
                    roomScores.put(score,room);
                });

        // Map the room score into list of response:
        for(Integer k : roomScores.keySet()){
            RoomMatchResponse roomMatchResponse = new RoomMatchResponse(
                    roomScores.get(k),k
            );
            matchResponse.add(roomMatchResponse);
        }

        return matchResponse;
    }

    private Integer processRoomScore(Room room){
        int score = 0;
        switch (room.getStatus()){
            case AVAILABLE ->
                score += 20;
            case IN_MAINTENANCE ->
                score += 10;
        }
        return score;
    }
}
