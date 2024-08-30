package com.unicorn.subject_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Major")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer majorId;
    @Column(name = "Name")
    private String majorName;
    @Column(name = "Type")
    private String type;
    @Column(name = "Level")
    private String level;
    @Column(name = "Description")
    private String description;
    @Column(name = "TotalCreditPoint")
    private Integer totalCreditPoint;
    @Column(name = "NonActiveDate")
    private LocalDate nonActiveDate;
}
