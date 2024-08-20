package com.doctorapp.doctorapp.Payload;

import com.doctorapp.doctorapp.Entity.Area;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AreaDto {
    private Long id;

    private String area;


}
