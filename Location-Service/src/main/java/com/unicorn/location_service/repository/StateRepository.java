package com.unicorn.location_service.repository;

import com.unicorn.location_service.dto.StateDto;
import com.unicorn.location_service.entity.State;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    @Query("""
            SELECT new com.unicorn.location_service.dto.StateDto(
                st.id,
                st.name,
                c.name
            )
            FROM State AS st
            JOIN st.country AS c
            WHERE (:countryId IS NULL OR st.countryId = :countryId)
            """)
    List<StateDto> getStates(Pageable pagination, Long countryId);
}
