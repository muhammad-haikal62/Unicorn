package com.unicorn.subject_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateInsertMajor {
    private Integer id;
    private String majorName;
    private String type;
    private String level;
    private String description;
    private Integer totalCreditPoint;
    private LocalDate nonActiveDate;
}
