package com.doctorapp.doctorapp.Repository;

import com.doctorapp.doctorapp.Entity.ConsultationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultationTimeRepository extends JpaRepository<ConsultationTime, Long> {


    // Custom query using the @Query annotation to find consultation times by status and doctor ID
    List<ConsultationTime> findByStatusAndDoctorId(String status, Long doctorId);

}