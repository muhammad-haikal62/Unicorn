package com.Student_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SortName", length = 3,nullable = false)
    private String sortName;

    @Column(name = "Name", length = 150,nullable = false)
    private String name;

    @Column(name = "PhoneCode", nullable = false)
    private Integer phoneCode;

    @OneToMany(mappedBy = "country")
    private List<State> states;
}
