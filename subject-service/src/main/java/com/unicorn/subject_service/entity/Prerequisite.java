package com.unicorn.subject_service.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Prerequisite")
public class Prerequisite {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SubjectID")
    private Integer subjectId;

    @ManyToOne
    @JoinColumn(name = "SubjectID", insertable=false, updatable=false)
    private Subject subject;

    @Column(name = "PrerequisiteID", insertable=false, updatable=false)
    private Integer prerequisiteId;

    @ManyToOne
    @JoinColumn(name = "PrerequisiteID")
    private Subject prerequisite;

    @Column(name = "Description")
    private String description;
}
