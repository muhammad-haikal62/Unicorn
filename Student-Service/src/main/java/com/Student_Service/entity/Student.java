package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "ID")
    private String  id;

    @Column(name = "FirstName",nullable = false,length = 50)
    private String firstName;

    @Column(name = "LastName",nullable = false,length = 50)
    private String lastName;

    @Column(name = "Penjurusan",nullable = true,length = 500)
    private String penjurusan;
}
