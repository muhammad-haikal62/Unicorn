package com.unicorn.enrollment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "MajorID")
    private Integer majorId;
    @Column(name = "Description")
    private String description;
    @Column(name = "Level")
    private String level;
    @Column(name = "CreditPoint")
    private Integer creditPoint;
    @Column(name = "Cost")
    private BigDecimal cost;
    @Column(name = "NonActiveDate")
    private LocalDateTime nonActiveDate;

    @OneToMany(mappedBy = "subject")
    private List<Competency> competency = new LinkedList<>();
}
