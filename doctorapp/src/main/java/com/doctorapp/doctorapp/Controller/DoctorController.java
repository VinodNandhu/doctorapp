package com.doctorapp.doctorapp.Controller;


import com.doctorapp.doctorapp.Payload.ConsultationTimeDto;
import com.doctorapp.doctorapp.Payload.DoctorDto;
import com.doctorapp.doctorapp.Service.ConsultationTimeService;
import com.doctorapp.doctorapp.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/v1/doctors") // Base URL for this controller
public class DoctorController {

    private  DoctorService doctorService; // Service layer dependency

    private  ConsultationTimeService consultationTimeService;

    // Constructor injection


    // Constructor injection for DoctorService
    public DoctorController(DoctorService doctorService, ConsultationTimeService consultationTimeService) {
        this.doctorService = doctorService;
        this.consultationTimeService = consultationTimeService;
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        // Returns a list of all doctors
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        // Call the service layer to find the doctor by ID
        DoctorDto doctorDto = doctorService.findDoctorById(id);

        // If the doctor is not found, return a 404 response
        if (doctorDto == null) {
            return ResponseEntity.notFound().build();
        }

        // If the doctor is found, return a 200 response with the doctor's data
        return ResponseEntity.ok(doctorDto);
    }

    @PostMapping//("/doctor")
    public DoctorDto createDoctor(@RequestBody DoctorDto doctorDto) {
        // Creates and returns a new doctor
        return doctorService.saveDoctor(doctorDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDetails) {
        // Updates and returns an existing doctor or 404 if not found
        DoctorDto updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
        return updatedDoctor != null ? ResponseEntity.ok(updatedDoctor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        // Deletes a doctor and returns a success message
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor with ID " + id + " is deleted successfully.");
    }
    @GetMapping("/by-specialization-and-location")
    public List<DoctorDto> findDoctorsBySpecializationAndLocation(
            @RequestParam String expertise,
            @RequestParam String city,
            @RequestParam String area
    ) {
        return doctorService.findDoctorsBySpecializationAndLocation(expertise, city, area);
    }
    @GetMapping("/by-status-and-doctor")
    public List<ConsultationTimeDto> getConsultationsByStatusAndDoctor(
            @RequestParam String status,
            @RequestParam Long doctorId) {
        return consultationTimeService.getConsultationTimesByStatusAndDoctorId(status, doctorId);
    }

}