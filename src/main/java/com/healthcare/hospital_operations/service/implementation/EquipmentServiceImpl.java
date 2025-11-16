package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.dto.EquipmentResponseDto;
import com.healthcare.hospital_operations.exception.EquipmentAlreadyExistsException;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public EquipmentResponseDto newEquipment(EquipmentRequestDto requestDto) {
        // check equipment existence:
        if(equipmentRepository.existsBySerialNumber(requestDto.getSerialNumber())){
            throw new EquipmentAlreadyExistsException(requestDto.getSerialNumber());
        }

        // Otherwise, add new equipment:
        Equipment equipment = new Equipment();
    }
}
