package com.unicorn.subject_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectSaveDto{
    private Integer id;

    private String code;

    private String name;

    private Integer majorId;

    private String description;

    private String level;

    private Integer creditPoint;

    private BigDecimal cost;

    private LocalDateTime nonActiveDate;
}
