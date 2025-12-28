package com.healthcare.hospital_operations.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRequestDto {

    @NotNull
    private String equipmentName;
    @NotNull
    private String modelNumber;
    @NotNull
    private String manufacturer;
    @NotNull
    private String serialNumber;
    @NotNull
    private LocalDate purchaseDate;
    @NotNull
    private LocalDate warrantyExpiry;
    @NotNull
    private LocalDate lastMaintenance;
    @NotNull
    private LocalDate nextMaintenance;
    @NotNull
    private String condition;
}
