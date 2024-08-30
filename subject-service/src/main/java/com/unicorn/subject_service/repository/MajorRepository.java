package com.unicorn.subject_service.repository;

import com.unicorn.subject_service.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query("""
            SELECT maj
            FROM Major AS maj
            """)
    List<Major> getMajors();
}
