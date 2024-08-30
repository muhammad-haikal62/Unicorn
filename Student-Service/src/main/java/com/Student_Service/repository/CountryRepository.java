package com.Student_Service.repository;


import com.Student_Service.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
