package com.unicorn.enrollment_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

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
