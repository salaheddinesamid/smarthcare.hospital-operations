package com.healthcare.hospital_operations.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EquipmentRequestDto {

    private String equipmentName;
    private String number;
    private String manufacturer;
    private String serialNumber;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiry;
    private LocalDate lastMaintenance;
    private LocalDate nextMaintenance;
    private String condition;
}
