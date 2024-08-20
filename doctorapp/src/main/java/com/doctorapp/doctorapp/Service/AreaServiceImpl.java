package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Entity.Area;
import com.doctorapp.doctorapp.Payload.AreaDto;
import com.doctorapp.doctorapp.Repository.AreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

// Service implementation for Area operations
@Service
public class AreaServiceImpl implements AreaService {
    // Dependency injection for AreaRepository and ModelMapper
    private final AreaRepository areaRepository;
    private final ModelMapper modelMapper;

    public AreaServiceImpl(AreaRepository areaRepository, ModelMapper modelMapper) {
        this.areaRepository = areaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AreaDto createArea(AreaDto areaDto) {
        // Convert AreaDto to Area entity
        Area area = modelMapper.map(areaDto, Area.class);
        // Save Area entity to database
        areaRepository.save(area);
        // Convert saved Area entity back to AreaDto
        return modelMapper.map(area, AreaDto.class);
    }

    @Override
    public AreaDto getArea(Long id) {
        // Find Area entity by ID
        Area area = areaRepository.findById(id).orElseThrow();
        // Convert Area entity to AreaDto
        return modelMapper.map(area, AreaDto.class);
    }

    @Override
    public AreaDto updateArea(Long id, AreaDto areaDto) {
        // Find Area entity by ID
        Area area = areaRepository.findById(id).orElseThrow();
        // Update Area entity with new values
        area.setArea(areaDto.getArea());
        // Save updated Area entity to database
        areaRepository.save(area);
        // Convert saved Area entity back to AreaDto
        return modelMapper.map(area, AreaDto.class);
    }

    @Override
    public void deleteArea(Long id) {
        // Delete Area entity by ID
        areaRepository.deleteById(id);
    }

}
