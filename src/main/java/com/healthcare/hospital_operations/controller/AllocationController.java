package com.healthcare.hospital_operations.controller;

import com.healthcare.hospital_operations.dto.AllocationRequestDetails;
import com.healthcare.hospital_operations.dto.RoomAllocationRequestDto;
import com.healthcare.hospital_operations.model.AllocationRequest;
import com.healthcare.hospital_operations.service.implementation.AllocationRequestQueryImpl;
import com.healthcare.hospital_operations.service.implementation.AllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/allocation")
public class AllocationController {

    private final AllocationServiceImpl allocationService;
    private final AllocationRequestQueryImpl allocationRequestQuery;

    @Autowired
    public AllocationController(AllocationServiceImpl allocationService, AllocationRequestQueryImpl allocationRequestQuery) {
        this.allocationService = allocationService;
        this.allocationRequestQuery = allocationRequestQuery;
    }

    @GetMapping("requests/get_all")
    public ResponseEntity<?> getAllRequests(){
        List<AllocationRequest> requests =
                allocationRequestQuery.getAllRequests();
        return ResponseEntity
                .status(200)
                .body(requests);
    }

    // This endpoint handles creating room allocations directly by an Admin
    @PostMapping("new")
    public ResponseEntity<?> newAllocation(){
        return null ;
    }

    // This endpoint handles requesting allocations by a Patient
    @PostMapping("requests/new")
    public ResponseEntity<?> requestAllocation(
            @RequestBody RoomAllocationRequestDto roomAllocationRequestDto
            ){
        AllocationRequestDetails newAllocation = allocationService.requestAllocation(roomAllocationRequestDto);
        return
                ResponseEntity.status(200)
                        .body(newAllocation);
    }
}
