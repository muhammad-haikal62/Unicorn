package com.unicorn.enrollment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EnrollmentDto {
    private Integer id;
    private String studentNumber;
    private LocalDateTime enrollDate;
    private Integer periodId;
    private Integer majorId;
    private Integer subjectId;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private BigDecimal fee;
    private String status;
}
