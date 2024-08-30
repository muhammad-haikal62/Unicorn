package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", length = 30, nullable = false)
    private String name;

    @Column(name = "CountryID",nullable = false)
    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = "CountryID", insertable = false,updatable = false)
    private Country country;

    @OneToMany(mappedBy = "state")
    private List<City> cities;
}
