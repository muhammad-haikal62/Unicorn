package com.unicorn.tutor_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateInsertTutor {
    private String staffNumber;
    private String username;
    private String password;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private Integer birthCountryId;
    private Integer birthCityId;
    private Integer citizenshipId;
    private String address;
    private LocalDate hireDate;
    private BigDecimal basicSalary;
    private BigDecimal allowance;
    private String EmployeeType;
}
