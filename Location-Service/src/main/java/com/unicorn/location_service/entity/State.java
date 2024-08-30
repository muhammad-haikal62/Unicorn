package com.unicorn.location_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Name", length = 30, nullable = false)
    private String name;
    @Column(name = "CountryID", nullable = false)
    private long countryId;
    @ManyToOne()
    @JoinColumn(name = "CountryID", insertable = false, updatable = false)
    private Country country;
}
