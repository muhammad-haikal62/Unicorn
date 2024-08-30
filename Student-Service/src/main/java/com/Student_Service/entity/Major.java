package com.Student_Service.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Type", length = 3, nullable = false)
    private String type;

    @Column(name = "Level", length = 1, nullable = false)
    private String level;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "TotalCreditPoint", nullable = false)
    private Integer totalCreditPoint;

    @Column(name = "NonActiveDate")
    private LocalDateTime nonActiveDate;

    @ManyToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private StudentMajor studentMajor;
}
