package com.healthcare.hospital_operations.repository;

import com.healthcare.hospital_operations.model.Room;
import com.healthcare.hospital_operations.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    boolean existsByRoomNumberAndFloorNumber(Integer roomNumber, Integer floorNumber);
    List<Room> findAllByRoomType(RoomType roomType);
}
