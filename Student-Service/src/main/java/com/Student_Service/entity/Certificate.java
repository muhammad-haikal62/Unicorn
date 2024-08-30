package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "StudentNumber", length = 20, nullable = false)
    private String studentNumber;

    @Column(name = "GraduateDate", nullable = false)
    private LocalDateTime graduateDate;

    @Column(name = "TotalMark", nullable = false)
    private Double totalMark;

    @Column(name = "Grade", length = 3, nullable = false)
    private String grade;

    @Column(name = "AcademicTitle", length = 200, nullable = false)
    private String academicTitle;

    @Column(name = "Level", length = 1, nullable = false)
    private String level;
}
