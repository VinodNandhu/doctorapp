package com.doctorapp.doctorapp.Controller;

import com.doctorapp.doctorapp.Payload.SpecializationDto;
import com.doctorapp.doctorapp.Service.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller for Specialization operations
@RestController
@RequestMapping("/api/specializations")

public class SpecializationController {
    // Dependency injection for SpecializationService
    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping
    public ResponseEntity<SpecializationDto> createSpecialization(@RequestBody SpecializationDto specializationDto) {
        // Create a new specialization
        SpecializationDto createdSpecialization = specializationService.createSpecialization(specializationDto);
        return ResponseEntity.ok(createdSpecialization);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationDto> getSpecialization(@PathVariable Long id) {
        // Get a specialization by ID
        SpecializationDto specialization = specializationService.getSpecialization(id);
        return ResponseEntity.ok(specialization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecializationDto> updateSpecialization(@PathVariable Long id, @RequestBody SpecializationDto specializationDto) {
        // Update an existing specialization
        SpecializationDto updatedSpecialization = specializationService.updateSpecialization(id, specializationDto);
        return ResponseEntity.ok(updatedSpecialization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        // Delete a specialization by ID
        specializationService.deleteSpecialization(id);
        return ResponseEntity.noContent().build();
    }

}
