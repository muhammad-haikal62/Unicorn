package com.unicorn.enrollment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InsertEnrollmentDto {
    @NotBlank
    @Length(max = 20)
    private String studentNumber;
    @NotNull
    @PastOrPresent
    private LocalDateTime enrollmentDate;
    @NotNull
    private Integer periodId;
    @PastOrPresent
    private LocalDateTime transactionDate;
    @Length(max = 2)
    private String paymentMethod;
    @PositiveOrZero
    private BigDecimal fee;
    @Length(max = 3)
    private String status;
}
