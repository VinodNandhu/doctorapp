package com.doctorapp.doctorapp.Controller;

import com.doctorapp.doctorapp.Payload.ConsultationTimeDto;
import com.doctorapp.doctorapp.Service.ConsultationTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/consultation-times")

public class ConsultationTimeController   {

    private final ConsultationTimeService consultationTimeService;

    // Constructor-based dependency injection
    public ConsultationTimeController(ConsultationTimeService consultationTimeService) {
        this.consultationTimeService = consultationTimeService;
    }

    @PostMapping
    public ResponseEntity<ConsultationTimeDto> createConsultationTime(@RequestBody ConsultationTimeDto consultationTimeDto) {
        // Create a new consultation time
        ConsultationTimeDto createdConsultationTime = consultationTimeService.createConsultationTime(consultationTimeDto);
        return ResponseEntity.ok(createdConsultationTime);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationTimeDto> getConsultationTimeById(@PathVariable Long id) {
        // Retrieve a consultation time by ID
        ConsultationTimeDto consultationTimeDto = consultationTimeService.getConsultationTimeById(id);
        return ResponseEntity.ok(consultationTimeDto);
    }

    @GetMapping
    public ResponseEntity<List<ConsultationTimeDto>> getAllConsultationTimes() {
        // Retrieve all consultation times
        List<ConsultationTimeDto> consultationTimes = consultationTimeService.getAllConsultationTimes();
        return ResponseEntity.ok(consultationTimes);
    }
//
//    @GetMapping("/doctor/{doctorId}")
//    public ResponseEntity<List<ConsultationTimeDto>> getConsultationTimesByDoctorId(@PathVariable Long doctorId) {
//        // Retrieve consultation times by doctor ID
//        List<ConsultationTimeDto> consultationTimes = consultationTimeService.getConsultationTimesByDoctorId(doctorId);
//        return ResponseEntity.ok(consultationTimes);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultationTimeDto> updateConsultationTime(@PathVariable Long id, @RequestBody ConsultationTimeDto consultationTimeDto) {
        // Update a consultation time
        ConsultationTimeDto updatedConsultationTime = consultationTimeService.updateConsultationTime(id, consultationTimeDto);
        return ResponseEntity.ok(updatedConsultationTime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultationTime(@PathVariable Long id) {
        // Delete a consultation time
        consultationTimeService.deleteConsultationTime(id);
        return ResponseEntity.noContent().build();
    }
}
