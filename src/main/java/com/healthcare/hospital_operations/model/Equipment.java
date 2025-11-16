package com.healthcare.hospital_operations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "serial _number",unique = true)
    private String serialNumber;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "warranty_expiry")
    private LocalDate warrantyExpiry;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    @Column(name = "last_maintenance")
    private LocalDate lastMaintenance;

    @Column(name = "next_maintenance")
    private LocalDate nextMaintenance;

    @Column(name = "condition")
    @Enumerated(EnumType.STRING)
    private EquipmentCondition condition;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
