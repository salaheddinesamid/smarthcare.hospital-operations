package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.service.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentMapperImpl implements EquipmentMapper {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentMapperImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public void validate(EquipmentRequestDto requestDto) {

    }

    @Override
    public Equipment mapToEquipment(EquipmentRequestDto requestDto) {
        // validate request:
        validate(requestDto);

        // set attributes:
        Equipment equipment = new Equipment();
        equipment/
    }
}
