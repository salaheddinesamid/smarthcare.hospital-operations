package com.healthcare.hospital_operations.controller;

import com.healthcare.hospital_operations.service.implementation.AllocationRequestQueryImpl;
import com.healthcare.hospital_operations.service.implementation.RoomAllocateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/allocation")
public class AllocationController {

    private final RoomAllocateServiceImpl roomAllocateService;
    private final AllocationRequestQueryImpl allocationRequestQuery;

    @Autowired
    public AllocationController(RoomAllocateServiceImpl roomAllocateService, AllocationRequestQueryImpl allocationRequestQuery) {
        this.roomAllocateService = roomAllocateService;
        this.allocationRequestQuery = allocationRequestQuery;
    }

    @GetMapping("requests/get_all")
    public ResponseEntity<?> getAllRequests(){
        return ResponseEntity
                .status(200)
                .body(List.of());
    }

    // This endpoint handles creating room allocations directly by an Admin
    @PostMapping("new")
    public ResponseEntity<?> newAllocation(){
        return null;
    }

    // This endpoint handles requesting allocations by a Patient
    @PostMapping("request-allocation")
    public ResponseEntity<?> requestAllocation(){
        return null;
    }
}
