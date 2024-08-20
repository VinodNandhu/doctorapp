package com.doctorapp.doctorapp.Service;

import com.doctorapp.doctorapp.Entity.City;
import com.doctorapp.doctorapp.Payload.CityDto;
import com.doctorapp.doctorapp.Repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
    // Service implementation for City oper@ations
public class CityServiceImpl implements CityService {
        private final CityRepository cityRepository;
        private final ModelMapper modelMapper;

        // Constructor-based injection
        public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
            this.cityRepository = cityRepository;
            this.modelMapper = modelMapper;
        }

        @Override
        public CityDto createCity(CityDto cityDto) {
            // Convert CityDto to City entity
            City city = modelMapper.map(cityDto, City.class);
            // Save City entity to database
            cityRepository.save(city);
            // Convert saved City entity back to CityDto
            return modelMapper.map(city, CityDto.class);
        }

        @Override
        public CityDto getCity(Long id) {
            // Find City entity by ID
            City city = cityRepository.findById(id).orElseThrow();
            // Convert City entity to CityDto
            return modelMapper.map(city, CityDto.class);
        }

        @Override
        public CityDto updateCity(Long id, CityDto cityDto) {
            // Find City entity by ID
            City city = cityRepository.findById(id).orElseThrow();
            // Update City entity with new values
            city.setName(cityDto.getName());
            // Save updated City entity to database
            cityRepository.save(city);
            // Convert saved City entity back to CityDto
            return modelMapper.map(city, CityDto.class);
        }

        @Override
        public void deleteCity(Long id) {
            // Delete City entity by ID
            cityRepository.deleteById(id);
        }
    }

