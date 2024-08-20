package com.doctorapp.doctorapp.Service;


import com.doctorapp.doctorapp.Entity.Doctor;
import com.doctorapp.doctorapp.Payload.DoctorDto;
import com.doctorapp.doctorapp.Repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Marks this class as a Spring service component
public class DoctorServiceImpl implements DoctorService {

    private  DoctorRepository doctorRepository; // Repository for doctor entity
    private  ModelMapper modelMapper; // ModelMapper for DTO conversion

    // Constructor injection for dependencies
    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DoctorDto> findAllDoctors() {
        // Converts list of Doctor entities to DoctorDto and returns it
        return doctorRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public String deleteDoctor(Long id) {
        // Deletes a doctor by ID
        doctorRepository.deleteById(id);
        return null ;
    }


    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        // Convert the DoctorDto object to a Doctor entity
        Doctor doctor = convertToEntity(doctorDto);

        // Save the Doctor entity in the database
        Doctor savedDoctor = doctorRepository.save(doctor);

        // Convert the saved Doctor entity back to a DoctorDto object
        return convertToDto(savedDoctor);
    }

    @Override
    public DoctorDto updateDoctor(Long id, DoctorDto doctorDetails) {
        // Find the doctor by ID
        return doctorRepository.findById(id)
                // If the doctor exists, update their details
                .map(doctor -> {
                    // Map the updated details to the existing doctor entity
                    modelMapper.map(doctorDetails, doctor);
                    // Save the updated doctor entity
                    return convertToDto(doctorRepository.save(doctor));
                })
                // If the doctor doesn't exist, throw an exception
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }



    @Override
    public DoctorDto findDoctorById(Long id) {
        // Find a doctor by ID and convert it to DoctorDto
        return doctorRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @Override
    public List<DoctorDto> findDoctorsBySpecializationAndLocation(String expertise, String city, String area) {
        List<Doctor> doctors = doctorRepository.findDoctorsBySpecializationAndLocation(expertise, city, area);
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
    }


    // Converts Doctor entity to DoctorDto
    private DoctorDto convertToDto(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDto.class);
    }

    // Converts DoctorDto to Doctor entity
    private Doctor convertToEntity(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }
}