package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "City")
public class City {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", length = 30, nullable = false)
    private String name;

    @Column(name = "StateID", nullable = false)
    private Integer stateId;
}
