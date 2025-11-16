package com.healthcare.hospital_operations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "allocations")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allocationId;

    @Column(name = "patient_id")
    private Integer patientId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "allocation_date")
    private LocalDateTime allocationDate;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "priority")
    private AllocationPriority priority;

    @Column(name = "issue")
    private String issue;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AllocationStatus status;
}
