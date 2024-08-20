package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Entity.Specialization;
import com.doctorapp.doctorapp.Payload.SpecializationDto;
import com.doctorapp.doctorapp.Repository.SpecializationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

// Service implementation for Specialization operations
@Service
public class SpecializationServiceImpl  implements SpecializationService {
    // Dependency injection for SpecializationRepository and ModelMapper
    private final SpecializationRepository specializationRepository;
    private final ModelMapper modelMapper;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository, ModelMapper modelMapper) {
        this.specializationRepository = specializationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SpecializationDto createSpecialization(SpecializationDto specializationDto) {
        // Convert SpecializationDto to Specialization entity
        Specialization specialization = modelMapper.map(specializationDto, Specialization.class);
        // Save Specialization entity to database
        specializationRepository.save(specialization);
        // Convert saved Specialization entity back to SpecializationDto
        return modelMapper.map(specialization, SpecializationDto.class);
    }

    @Override
    public SpecializationDto getSpecialization(Long id) {
        // Find Specialization entity by ID
        Specialization specialization = specializationRepository.findById(id).orElseThrow();
        // Convert Specialization entity to SpecializationDto
        return modelMapper.map(specialization, SpecializationDto.class);
    }

    @Override
    public SpecializationDto updateSpecialization(Long id, SpecializationDto specializationDto) {
        // Find Specialization entity by ID
        Specialization specialization = specializationRepository.findById(id).orElseThrow();
        // Update Specialization entity with new values
        specialization.setExpertise(specializationDto.getExpertise());
        // Save updated Specialization entity to database
        specializationRepository.save(specialization);
        // Convert saved Specialization entity back to SpecializationDto
        return modelMapper.map(specialization, SpecializationDto.class);
    }

    @Override
    public void deleteSpecialization(Long id) {
        // Delete Specialization entity by ID
        specializationRepository.deleteById(id);
    }


}
