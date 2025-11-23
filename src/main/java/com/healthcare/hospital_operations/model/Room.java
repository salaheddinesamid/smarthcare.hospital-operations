package com.healthcare.hospital_operations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "available_places")
    private Integer availablePlaces;

    @Column(name = "available_in")
    private LocalDateTime availableIn;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RoomStatus status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipments;
}
