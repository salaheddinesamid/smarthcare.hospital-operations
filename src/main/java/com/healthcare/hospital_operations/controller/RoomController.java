package com.healthcare.hospital_operations.controller;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.dto.RoomResponseDto;
import com.healthcare.hospital_operations.service.implementation.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/room-management")
public class RoomController {

    private final RoomServiceImpl roomService;

    @Autowired
    public RoomController(RoomServiceImpl roomService) {
        this.roomService = roomService;
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
