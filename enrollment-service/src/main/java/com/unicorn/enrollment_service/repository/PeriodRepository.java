package com.unicorn.enrollment_service.repository;

import com.unicorn.enrollment_service.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {
    @Query("""
            SELECT per
            FROM Enrollment en
            JOIN en.period per
            WHERE en.id = :id
            """)
    Period getPeriodByEnrollment(Integer id);
}
