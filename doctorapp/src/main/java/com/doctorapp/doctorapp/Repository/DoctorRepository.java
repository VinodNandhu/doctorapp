package com.doctorapp.doctorapp.Repository;

import com.doctorapp.doctorapp.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository// Indicates that this interface is a Spring Data repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // JpaRepository provides basic CRUD operations
    @Query("SELECT d FROM Doctor d "
            + "JOIN d.city c "
            + "JOIN d.specialization s "
            + "JOIN d.area a "
            + "WHERE s.expertise = :expertise AND c.name = :city AND a.area = :area")
    List<Doctor> findDoctorsBySpecializationAndLocation(
            @Param("expertise") String expertise,
            @Param("city") String city,
            @Param("area") String area);
}