package com.healthcare.hospital_operations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EquipmentType type;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "serial_number", unique = false) // FIXED
    private String serialNumber;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "warranty_expiry")
    private LocalDate warrantyExpiry;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EquipmentStatus status;

    @Column(name = "last_maintenance")
    private LocalDate lastMaintenance;

    @Column(name = "next_maintenance")
    private LocalDate nextMaintenance;

    @Enumerated(EnumType.STRING)
    private EquipmentCondition equipmentCondition;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")  // FK stored in Equipment table
    private Room room;
}
