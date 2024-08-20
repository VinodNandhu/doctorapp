package com.doctorapp.doctorapp.Controller;

import com.doctorapp.doctorapp.Payload.AreaDto;
import com.doctorapp.doctorapp.Service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller for Area operations
@RestController
@RequestMapping("/api/areas")

public class AreaController {
    // Dependency injection for AreaService
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto areaDto) {
        // Create a new area
        AreaDto createdArea = areaService.createArea(areaDto);
        return ResponseEntity.ok(createdArea);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getArea(@PathVariable Long id) {
        // Get an area by ID
        AreaDto area = areaService.getArea(id);
        return ResponseEntity.ok(area);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDto> updateArea(@PathVariable Long id, @RequestBody AreaDto areaDto) {
        // Update an existing area
        AreaDto updatedArea = areaService.updateArea(id, areaDto);
        return ResponseEntity.ok(updatedArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        // Delete an area by ID
        areaService.deleteArea(id);
        return ResponseEntity.noContent().build();
    }
}
