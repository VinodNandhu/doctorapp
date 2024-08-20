package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Entity.*;
import com.doctorapp.doctorapp.Payload.AreaDto;
import com.doctorapp.doctorapp.Payload.ConsultationTimeDto;
import com.doctorapp.doctorapp.Repository.AreaRepository;
import com.doctorapp.doctorapp.Repository.CityRepository;
import com.doctorapp.doctorapp.Repository.ConsultationTimeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConsultationTimeServiceImpl implements ConsultationTimeService {

    private  ConsultationTimeRepository consultationTimeRepository;
    private  ModelMapper modelMapper;

//    private CityRepository cityRepository;
//    private AreaRepository areaRepository;

    // Constructor-based dependency injection
    public ConsultationTimeServiceImpl(ConsultationTimeRepository consultationTimeRepository, ModelMapper modelMapper) {
        this.consultationTimeRepository = consultationTimeRepository;
        this.modelMapper = modelMapper;
//        this.cityRepository = cityRepository;
//        this.areaRepository = areaRepository;
    }

    @Override
    public ConsultationTimeDto createConsultationTime(ConsultationTimeDto consultationTimeDto) {
        // Convert DTO to entity, save it, then convert back to DTO
        ConsultationTime consultationTime = modelMapper.map(consultationTimeDto, ConsultationTime.class);
        ConsultationTime savedConsultationTime = consultationTimeRepository.save(consultationTime);
        return modelMapper.map(savedConsultationTime, ConsultationTimeDto.class);
    }

    @Override
    public ConsultationTimeDto getConsultationTimeById(Long id) {
        // Retrieve entity by ID and convert to DTO
        ConsultationTime consultationTime = consultationTimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConsultationTime not found with id " + id));
        return modelMapper.map(consultationTime, ConsultationTimeDto.class);
    }

    @Override
    public List<ConsultationTimeDto> getAllConsultationTimes() {
        // Retrieve all entities and convert them to DTOs
        List<ConsultationTime> consultationTimes = consultationTimeRepository.findAll();
        return consultationTimes.stream()
                .map(consultationTime -> modelMapper.map(consultationTime, ConsultationTimeDto.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ConsultationTimeDto> getConsultationTimesByDoctorId(Long doctorId) {
//        // Retrieve entities by doctor ID and convert them to DTOs
//        List<ConsultationTime> consultationTimes = consultationTimeRepository.findByDoctorId(doctorId);
//        return consultationTimes.stream()
//                .map(consultationTime -> modelMapper.map(consultationTime, ConsultationTimeDto.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public ConsultationTimeDto updateConsultationTime(Long id, ConsultationTimeDto consultationTimeDto) {
        // Update entity and save changes
        ConsultationTime existingConsultationTime = consultationTimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConsultationTime not found with id " + id));
        existingConsultationTime.setDate(consultationTimeDto.getDate());
        existingConsultationTime.setTime(consultationTimeDto.getTime());
        existingConsultationTime.setStatus(consultationTimeDto.getStatus());
        ConsultationTime updatedConsultationTime = consultationTimeRepository.save(existingConsultationTime);
        return modelMapper.map(updatedConsultationTime, ConsultationTimeDto.class);
    }

    @Override
    public void deleteConsultationTime(Long id) {
        // Delete entity by ID
        consultationTimeRepository.deleteById(id);
    }

    @Override
    public List<ConsultationTimeDto> getConsultationTimesByStatusAndDoctorId(String status, Long doctorId) {
        // Retrieve a list of ConsultationTime entities from the repository based on the provided status and doctorId
        List<ConsultationTime> consultationTimes = consultationTimeRepository.findByStatusAndDoctorId(status, doctorId);

        // Stream through the list of ConsultationTime entities and map each to a ConsultationTimeDto
        return consultationTimes.stream().map(consultationTime -> {
            // Map the ConsultationTime entity to a ConsultationTimeDto using ModelMapper
            ConsultationTimeDto dto = modelMapper.map(consultationTime, ConsultationTimeDto.class);

            // Get the associated Doctor entity from the ConsultationTime entity
            Doctor doctor = consultationTime.getDoctor();

            // Check if the Doctor entity is not null
            if (doctor != null) {
                // Set the doctor's name in the DTO
                dto.setDoctorName(doctor.getName());
                // Set the doctor's profile in the DTO
                dto.setDoctorProfile(doctor.getProfile());
                // Set the doctor's experience in the DTO
                dto.setDoctorExperience(doctor.getExperience());

                // Get the associated Specialization entity from the Doctor entity
                Specialization specialization = doctor.getSpecialization();
                // Check if the Specialization entity is not null
                if (specialization != null) {
                    // Set the specialization name in the DTO
                    dto.setSpecializationName(specialization.getName());
                }

                // Get the associated City entity from the Doctor entity
                City city = doctor.getCity();
                // Check if the City entity is not null
                if (city != null) {
                    // Set the city name in the DTO
                    dto.setCityName(city.getName());
                }

                // Get the associated Area entity from the Doctor entity
                Area area = doctor.getArea();
                // Check if the Area entity is not null
                if (area != null) {
                    // Set the area name in the DTO
                    dto.setAreaName(area.getName());
                }
            }

            // Return the populated DTO
            return dto;
            // Collect the stream into a List and return it
        }).collect(Collectors.toList());

    }


}
