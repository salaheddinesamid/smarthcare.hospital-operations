package com.healthcare.hospital_operations.controller;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.dto.EquipmentResponseDto;
import com.healthcare.hospital_operations.service.implementation.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

    private final EquipmentServiceImpl equipmentService;

    @Autowired
    public EquipmentController(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAll(){
        List<EquipmentResponseDto> response = equipmentService.getAllEquipments();
        return ResponseEntity.status(200)
                .body(response);
    }

    @PostMapping("new")
    public ResponseEntity<?> newEquipment(
            @RequestBody EquipmentRequestDto requestDto
            ){
        EquipmentResponseDto response = equipmentService.newEquipment(requestDto);

        return ResponseEntity.status(200)
                .body(response);
    }
}

