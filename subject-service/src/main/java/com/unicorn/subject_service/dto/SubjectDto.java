package com.unicorn.subject_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDto {
    private Integer id;

    private String code;

    private String name;

    private Integer majorId;

    private String description;

    private String level;

    private Integer creditPoint;

    private BigDecimal cost;

    private LocalDate nonActiveDate;
}
