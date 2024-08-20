package com.doctorapp.doctorapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "consultation_time")
public class ConsultationTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false) // Stores the date of the consultation
    private LocalDate date;

    @Column(name = "time", nullable = false) // Stores the time of the consultation
    private String time;

    @ManyToOne // Many consultation times can belong to one doctor
    @JoinColumn(name = "doctor_id") // Foreign key column in the database
    private Doctor doctor;

    @Column(name = "status", nullable = false) // Stores the status (e.g., pending, completed)
    private String status;


}