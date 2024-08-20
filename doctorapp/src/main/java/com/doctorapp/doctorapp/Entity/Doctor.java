package com.doctorapp.doctorapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // Marks this class as a JPA entity
@Table(name = "doctor") // Specifies the table name in the database
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    @Column(name = "id", nullable = false) // Maps this field to a column in the database
    private Long id;

    @Column(name = "name", nullable = false, length = 150) // Maps the name field
    private String name;

    @Column(name = "experience", nullable = false) // Maps the experience field
    private Integer experience;

    @Column(name = "profile", nullable = false, length = 2000) // Maps the profile field
    private String profile;

    @ManyToOne // Many doctors can have one specialization
    @JoinColumn(name = "specialization_id") // Maps the foreign key for specialization
    private Specialization specialization;

    @ManyToOne // Many doctors can be in one city
    @JoinColumn(name = "city_id") // Maps the foreign key for city
    private City city;

    @ManyToOne // Many doctors can be in one area
    @JoinColumn(name = "area_id") // Maps the foreign key for area
    private Area area;


}
