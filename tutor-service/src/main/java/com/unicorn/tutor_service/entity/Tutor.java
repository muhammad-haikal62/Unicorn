package com.unicorn.tutor_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "City")
public class Tutor {
    @Id
    @Column(name = "StaffNumber", length = 20)
    private String staffNumber;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Title")
    private String title;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "BirthCountryID")
    private Integer birthCountryId;

    @Column(name = "BirthCityID")
    private Integer birthCityId;

    @Column(name = "CitizenshipID")
    private Integer citizenshipId;

    @Column(name = "Address")
    private String address;

    @Column(name = "HireDate")
    private LocalDate hireDate;

    @Column(name = "BasicSalary")
    private BigDecimal basicSalary;

    @Column(name = "Allowance")
    private BigDecimal allowance;

    @Column(name = "EmployeeType")
    private String EmployeeType;
}
