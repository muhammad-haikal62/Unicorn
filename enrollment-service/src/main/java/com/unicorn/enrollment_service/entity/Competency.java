package com.unicorn.enrollment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Competency")
public class Competency {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "StaffNumber")
    private String staffNumber;
    @Column(name = "SubjectID")
    private Integer subjectId;

    @OneToMany(mappedBy = "competency")
    private List<Period> period = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "SubjectID", insertable = false, updatable = false)
    private Subject subject;
}
