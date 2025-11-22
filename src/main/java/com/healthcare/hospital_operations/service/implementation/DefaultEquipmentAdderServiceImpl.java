package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.EquipmentRequestDto;
import com.healthcare.hospital_operations.exception.EquipmentAlreadyExistsException;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.service.EquipmentAdderService;
import org.springframework.stereotype.Component;

@Component
public class DefaultEquipmentAdderServiceImpl implements EquipmentAdderService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapperImpl equipmentMapper;

    public DefaultEquipmentAdderServiceImpl(EquipmentRepository equipmentRepository, EquipmentMapperImpl equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    @Override
    public void validate(EquipmentRequestDto requestDto) {

    }

    @Override
    public Equipment add(EquipmentRequestDto requestDto) {
        // check if the equipment already exists:
        boolean exists = equipmentRepository.existsBySerialNumber(requestDto.getSerialNumber());
        if(exists){
            throw new EquipmentAlreadyExistsException(requestDto.getSerialNumber());
        }

        // Otherwise:
        Equipment newEquipment = equipmentMapper.mapToEquipment(requestDto);

        // save the new equipment:
        return equipmentRepository.save(newEquipment);
    }
}
