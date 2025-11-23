package com.healthcare.hospital_operations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "allocation_requests")
public class AllocationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "priority")
    private AllocationPriority allocationPriority;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "room_type")
    private RoomType roomType;
}
