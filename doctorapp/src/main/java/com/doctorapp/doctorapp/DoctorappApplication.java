package com.doctorapp.doctorapp;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorappApplication.class, args);
	}
	// Bean definition for ModelMapper
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper(); // Creates and returns a new ModelMapper instance
	}
}
