package com.healthcare.hospital_operations.controller;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.service.implementation.RoomQueryServiceImpl;
import com.healthcare.hospital_operations.service.implementation.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/room-management")
public class RoomController {

    private final RoomServiceImpl roomService;
    private final RoomQueryServiceImpl roomQueryService;

    @Autowired
    public RoomController(RoomServiceImpl roomService, RoomQueryServiceImpl roomQueryService) {
        this.roomService = roomService;
        this.roomQueryService = roomQueryService;
    }

    @GetMapping("get_all")
    public ResponseEntity<?> getAllRooms(){
        List<RoomResponseDto> response = roomQueryService
                .getAllRooms();
        return ResponseEntity.status(200)
                .body(response);
    }

    @GetMapping("get-matches")
    public ResponseEntity<?> getBestRoomMatches(@RequestParam String disease, @RequestParam LocalDateTime availability, @RequestParam String priority){
        return null;
    }

    @PostMapping("new")
    public ResponseEntity<?> addNewRoom(@RequestBody NewRoomRequestDto requestDto){
        RoomResponseDto response = roomService.newRoom(
                requestDto
        );
        return ResponseEntity
                .status(200)
                .body(Map.of(
                        "message","The room has been successfully added in the system","body",response
                ));
    }
}
