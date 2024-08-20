package com.doctorapp.doctorapp.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationTimeDto {
    private Long id; // ID of the consultation time
    private LocalDate date; // Date of the consultation
    private String time; // Time of the consultation
    private String status; // Status of the consultation

    // Add Doctor information
    private String doctorName;
    private String doctorProfile;
    private Integer doctorExperience;
    private String specializationName ;
    private String cityName;
    private String areaName;

//    public void setSpecializationName(String name) {
//    }


//    public void setSpecializationId(Object specializationId) {
//    }
//
//    public void setCityId(Object cityId) {
//    }
//
//    public void setAreaId(Object areaId) {
//    }
//
//    public void setDoctorId(Long id) {
//    }
}
