package com.healthcare.hospital_operations.dto;

import com.healthcare.hospital_operations.model.Equipment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EquipmentResponseDto {
    private Long equipmentId;
    private String equipmentName;
    private String modelNumber;
    private String manufacturer;
    private String serialNumber;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiry;
    private LocalDate lastMaintenance;
    private LocalDate nextMaintenance;
    private String condition;

    public EquipmentResponseDto(Equipment equipment){
        this.equipmentId = equipment.getEquipmentId();
        this.equipmentName = equipment.getName();
        this.modelNumber = equipment.getModelNumber();
        this.manufacturer = equipment.getManufacturer();
        this.serialNumber = equipment.getSerialNumber();
        this.purchaseDate = equipment.getPurchaseDate();
        this.warrantyExpiry = equipment.getWarrantyExpiry();
        this.lastMaintenance = equipment.getLastMaintenance();
        this.nextMaintenance = equipment.getNextMaintenance();
        this.condition = equipment.getEquipmentCondition().toString();
    }
}
