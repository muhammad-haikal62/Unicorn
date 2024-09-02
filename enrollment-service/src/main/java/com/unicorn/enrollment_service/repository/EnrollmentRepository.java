package com.unicorn.enrollment_service.repository;

import com.unicorn.enrollment_service.dto.EnrollmentDto;
import com.unicorn.enrollment_service.entity.Enrollment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("""
            SELECT new com.unicorn.enrollment_service.dto.EnrollmentDto(
                enl.id,
                enl.studentNumber,
                enl.enrollDate,
                enl.periodID,
                sub.majorId,
                sub.id,
                enl.transactionDate,
                enl.paymentMethod,
                enl.fee,
                enl.status
            )
            FROM Enrollment enl
            JOIN enl.period per
            JOIN per.competency com
            JOIN com.subject sub
            WHERE (:id IS NULL OR enl.id = :id)
            AND (:majorId IS NULL OR sub.majorId = :majorId)
            AND (:subjectId IS NULL OR sub.id = :subjectId)""")
    List<EnrollmentDto> getEnrollment(Integer id, Integer majorId, Integer subjectId, Pageable pageable);
}
