package com.doctorapp.doctorapp.Repository;


import com.doctorapp.doctorapp.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}