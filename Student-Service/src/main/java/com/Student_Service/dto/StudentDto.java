package com.Student_Service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String studentNumber;

    private String username;

    private String password;

    private String title;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private LocalDateTime birthDate;

    private Integer birthCountryId;

    private Integer birthCityId;

    private Integer citizenshipId;

    private String address;

    private LocalDateTime registerDate;

    private Integer totalCreditPoint;
}
