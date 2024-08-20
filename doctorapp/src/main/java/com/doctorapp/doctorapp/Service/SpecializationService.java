package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Payload.SpecializationDto;

public interface SpecializationService {

        // Create a new specialization
        SpecializationDto createSpecialization(SpecializationDto specializationDto);
        // Get a specialization by ID
        SpecializationDto getSpecialization(Long id);
        // Update an existing specialization
        SpecializationDto updateSpecialization(Long id, SpecializationDto specializationDto);
        // Delete a specialization by ID
        void deleteSpecialization(Long id);

}
