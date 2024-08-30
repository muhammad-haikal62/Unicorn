package com.unicorn.location_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "ShortName", length = 3, nullable = false)
    private String shortName;
    @Column(name = "Name", length = 150, nullable = false)
    private String name;
    @Column(name = "PhoneCode", nullable = false)
    private Integer phoneCode;
    @OneToMany(mappedBy = "country")
    private List<State> states;
}
