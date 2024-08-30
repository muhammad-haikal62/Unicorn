package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "StudentNumber",length = 20)
    private String studentNumber;

    @Column(name = "Username",nullable = false,length = 50)
    private String username;

    @Column(name = "Password",nullable = false,length = 200)
    private String password;

    @Column(name = "Title",nullable = false,length = 5)
    private String title;

    @Column(name = "FirstName",nullable = false,length = 50)
    private String firstName;

    @Column(name = "MiddleName",nullable = true,length = 50)
    private String middleName;

    @Column(name = "LastName",nullable = true,length = 50)
    private String lastName;

    @Column(name = "Gender",nullable = false,length = 1)
    private String gender;

    @Column(name = "BirthDate",nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "BirthCountryID",nullable = false)
    private Integer birthCountryId;

    @Column(name = "BirthCityID",nullable = false)
    private Integer birthCityId;

    @Column(name = "CitizenshipID",nullable = false)
    private Integer citizenshipId;

    @Column(name = "Address",nullable = true,length = 500)
    private String address;

    @Column(name = "RegisterDate",nullable = false)
    private LocalDateTime registerDate;

    @Column(name = "TotalCreditPoint",nullable = false)
    private Integer totalCreditPoint;
}
