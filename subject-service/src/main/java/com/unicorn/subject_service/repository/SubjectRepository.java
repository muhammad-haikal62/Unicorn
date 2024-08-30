package com.unicorn.subject_service.repository;

import com.unicorn.subject_service.entity.Subject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("""
            SELECT sub
            FROM Subject sub
            WHERE (:subjectId = 0 OR sub.id = :subjectId)
            AND (:majorId = 0 OR sub.majorId = :majorId)
            """)
    List<Subject> getSubjects(Pageable pagination, Integer subjectId, Integer majorId);

}
