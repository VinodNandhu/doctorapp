package com.doctorapp.doctorapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data", nullable = false)
        private LocalDate data;

        @Column(name = "time", nullable = false)
        private String time;

        @ManyToOne
        @JoinColumn(name = "doctor_id")
        private Doctor doctor;

        @ManyToOne
        @JoinColumn(name = "patient_id")
        private Patient patient;

}