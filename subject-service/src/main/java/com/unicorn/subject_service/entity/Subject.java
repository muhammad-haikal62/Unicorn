package com.unicorn.subject_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "ID")
    private Integer id;

    @OneToMany(mappedBy = "subject")
    private List<Prerequisite> subjectList;

    @OneToMany(mappedBy = "prerequisite")
    private List<Prerequisite> prerequisiteList;

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

}
