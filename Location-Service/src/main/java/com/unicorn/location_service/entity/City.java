package com.unicorn.location_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "City")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Name", length = 30, nullable = false)
    private String name;
    @Column(name = "StateID", nullable = false)
    private long stateId;
    @ManyToOne
    @JoinColumn(name = "StateID", insertable = false, updatable = false)
    private State state;
}
