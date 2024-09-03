package com.unicorn.location_service.repository;

import com.unicorn.location_service.dto.CountryDto;
import com.unicorn.location_service.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("""
            SELECT new com.unicorn.location_service.dto.CountryDto(
                cou.id,
                cou.sortName,
                cou.name,
                cou.phoneCode
            )
            FROM Country cou
            """)
    List<CountryDto> getAll();
}
