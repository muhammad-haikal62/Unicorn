package com.unicorn.enrollment_service.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "StudentNumber", length = 20, nullable = false)
    private String studentNumber;
    @Column(name = "EnrollDate", nullable = false)
    private LocalDateTime enrollDate;
    @Column(name = "PeriodID", nullable = false)
    private Integer periodID;
    @Column(name = "TransactionDate")
    private LocalDateTime transactionDate;
    @Column(name = "PaymentMethod", length = 2)
    private String paymentMethod;
    @Column(name = "Fee")
    private BigDecimal fee;
    @Column(name = "Status", length = 3)
    private String status;
    @ManyToOne
    @JoinColumn(name = "PeriodID", insertable = false, updatable = false)
    private Period period;
}
