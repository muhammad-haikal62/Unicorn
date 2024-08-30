package com.unicorn.location_service.repository;

import com.unicorn.location_service.dto.CityDto;
import com.unicorn.location_service.entity.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("""
            SELECT new com.unicorn.location_service.dto.CityDto(
                ct.id,
                ct.name,
                st.name
            )
            FROM City AS ct
            JOIN ct.state AS st
            """)
    List<CityDto> getCities(Pageable pagination);

}
