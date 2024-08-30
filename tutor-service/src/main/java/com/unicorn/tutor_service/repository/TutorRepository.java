package com.unicorn.tutor_service.repository;

import com.unicorn.tutor_service.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, String> {
    @Query("""
            SELECT tut
            FROM Tutor AS tut
            """)
    List<Tutor> getALlTutor();
}
