package com.unicorn.subject_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDateTime nonActiveDate;
}
