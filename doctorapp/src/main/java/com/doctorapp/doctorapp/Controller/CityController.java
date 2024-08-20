package com.doctorapp.doctorapp.Controller;


import com.doctorapp.doctorapp.Payload.CityDto;
import com.doctorapp.doctorapp.Service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller for City operations
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private  CityService cityService;

    // Constructor-based injection
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        CityDto createdCity = cityService.createCity(cityDto);
        return ResponseEntity.ok(createdCity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCity(@PathVariable Long id) {
        CityDto city = cityService.getCity(id);
        return ResponseEntity.ok(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDto> updateCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        CityDto updatedCity = cityService.updateCity(id, cityDto);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}