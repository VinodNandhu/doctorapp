package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Payload.ConsultationTimeDto;

import java.util.List;

public interface ConsultationTimeService {
    ConsultationTimeDto createConsultationTime(ConsultationTimeDto consultationTimeDto); // Create a new consultation time

    ConsultationTimeDto getConsultationTimeById(Long id); // Get a consultation time by ID

    List<ConsultationTimeDto> getAllConsultationTimes(); // Get all consultation times

   // List<ConsultationTimeDto> getConsultationTimesByDoctorId(Long doctorId); // Get consultation times by doctor ID

    ConsultationTimeDto updateConsultationTime(Long id, ConsultationTimeDto consultationTimeDto); // Update a consultation time by ID

    void deleteConsultationTime(Long id); // Delete a consultation time by ID

    List<ConsultationTimeDto> getConsultationTimesByStatusAndDoctorId(String status, Long doctorId);
}