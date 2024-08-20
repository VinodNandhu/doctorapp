package com.doctorapp.doctorapp.Service;



import com.doctorapp.doctorapp.Payload.DoctorDto;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<DoctorDto> findAllDoctors(); // Fetches all doctors

//    Optional<DoctorDto> findDoctorById(Long id); // Fetches a doctor by ID

    DoctorDto saveDoctor(DoctorDto doctorDto); // Saves a new doctor

    DoctorDto updateDoctor(Long id, DoctorDto doctorDetails); // Updates an existing doctor

    String deleteDoctor(Long id); // Deletes a doctor by ID

    DoctorDto findDoctorById(Long id);


    List<DoctorDto> findDoctorsBySpecializationAndLocation(String expertise, String city, String area);
}
