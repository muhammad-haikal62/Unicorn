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
                enl.transactionDate,
                enl.paymentMethod,
                enl.fee,
                enl.status
            )
            FROM Enrollment enl""")
    List<EnrollmentDto> getByPage(Pageable pageable);

    @Query("""
            SELECT new com.unicorn.enrollment_service.dto.EnrollmentDto(
                enl.id,
                enl.studentNumber,
                enl.enrollDate,
                enl.periodID,
                enl.transactionDate,
                enl.paymentMethod,
                enl.fee,
                enl.status
            )
            FROM Enrollment enl
            WHERE enl.id = :id""")
    EnrollmentDto getEnrollmentById(Integer id);
}
