package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "StudentMajor")
public class StudentMajor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "StudentNumber", length = 20, nullable = false)
    private String studentNumber;

    @Column(name = "MajorID", nullable = false)
    private Integer majorId;

    @Column(name = "SetDate", nullable = false)
    private LocalDate setDate;

    @Column(name = "CompleteDate", nullable = false)
    private LocalDate completeDate;
}
