package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Payload.AreaDto;

public interface AreaService {
    // Create a new area
    AreaDto createArea(AreaDto areaDto);
    // Get an area by ID
    AreaDto getArea(Long id);
    // Update an existing area
    AreaDto updateArea(Long id, AreaDto areaDto);
    // Delete an area by ID
    void deleteArea(Long id);
}
