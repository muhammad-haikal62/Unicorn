package com.unicorn.subject_service.repository;

import com.unicorn.subject_service.entity.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrerequisiteRepository extends JpaRepository<Prerequisite,Integer> {
    @Query("""
            SELECT pre.subjectId
            FROM Prerequisite pre
            WHERE (:prerequisiteId = 0 OR pre.prerequisiteId =:prerequisiteId)
            """)
    List<Integer> getSubjectId(Integer prerequisiteId);
}
