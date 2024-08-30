package com.unicorn.tutor_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TutorGridDto {
    private String fullName;
    private String gender;
    private LocalDate birthDate;
}
