package com.unicorn.tutor_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Tutor {
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
