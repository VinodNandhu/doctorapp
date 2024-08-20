package com.doctorapp.doctorapp.Payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Long id; // Doctor ID
    private String name; // Doctor name
    private Integer experience; // Doctor experience in years
    private String profile; // Doctor profile description
}

