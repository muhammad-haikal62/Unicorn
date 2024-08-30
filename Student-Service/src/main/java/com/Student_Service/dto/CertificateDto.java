package com.Student_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificateDto {
    private Integer id;
    private String studentNumber;
    private LocalDateTime graduateDate;
    private Double totalMark;
    private String grade;
    private String academicTitle;
    private String level;
}
