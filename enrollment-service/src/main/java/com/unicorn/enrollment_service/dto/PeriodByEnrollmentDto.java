package com.unicorn.enrollment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PeriodByEnrollmentDto {
    private Integer periodId;
    private Integer competencyId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
