package com.doctorapp.doctorapp.Service;


import com.doctorapp.doctorapp.Payload.CityDto;

// Service interface for City operations
public interface CityService {
        CityDto createCity(CityDto cityDto); // Create a new city
        CityDto getCity(Long id); // Get a city by ID
        CityDto updateCity(Long id, CityDto cityDto); // Update a city
        void deleteCity(Long id); // Delete a city
    }

