package com.healthcare.hospital_operations.repository;

import com.healthcare.hospital_operations.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

    boolean existsByRoomNumberAndFloorNumber(Integer roomNumber, Integer floorNumber);
}
