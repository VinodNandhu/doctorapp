package com.doctorapp.doctorapp.Repository;

import com.doctorapp.doctorapp.Entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}