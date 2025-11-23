package com.healthcare.hospital_operations.service.implementation;

import com.healthcare.hospital_operations.dto.NewRoomRequestDto;
import com.healthcare.hospital_operations.exception.RoomAlreadyExistsException;
import com.healthcare.hospital_operations.model.Equipment;
import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomStatus;
import com.healthcare.hospital_operations.model.RoomType;
import com.healthcare.hospital_operations.repository.EquipmentRepository;
import com.healthcare.hospital_operations.repository.RoomRepository;
import com.healthcare.hospital_operations.service.RoomAdder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultRoomAdderImpl implements RoomAdder {
    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public DefaultRoomAdderImpl(RoomRepository roomRepository, EquipmentRepository equipmentRepository) {
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public boolean supports(String roomType) {
        return RoomType.GENERAL.equals(RoomType.valueOf(roomType));
    }

    @Override
    @Transactional
    public Room add(String type, NewRoomRequestDto requestDto) {
        // verify if the room already exists:
        if(roomRepository.existsByRoomNumberAndFloorNumber(requestDto.getRoomNumber(), requestDto.getFloorNumber())){
            throw new RoomAlreadyExistsException("");
        }

        // create new room:
        Room room = new Room();
        room.setCapacity(requestDto.getCapacity());
        room.setAvailablePlaces(requestDto.getCapacity());
        room.setFloorNumber(requestDto.getFloorNumber());
        room.setRoomNumber(requestDto.getRoomNumber());
        room.setRoomType(RoomType.valueOf(requestDto.getRoomType()));
        room.setStatus(RoomStatus.AVAILABLE);

        // process and add equipments:
        List<Equipment> equipments = processEquipment(requestDto.getEquipments());
        room.setEquipments(equipments);

        // save the room:
        return roomRepository.save(room);
    }


    private List<Equipment> processEquipment(List<Long> ids){
        return equipmentRepository.findAllById(ids);
    }


}
