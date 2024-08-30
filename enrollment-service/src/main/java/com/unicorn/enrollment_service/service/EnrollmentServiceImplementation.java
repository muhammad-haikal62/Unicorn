package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.entity.Enrollment;
import com.unicorn.enrollment_service.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImplementation implements EnrollmentService {
    private final EnrollmentRepository repository;

    @Autowired
    public EnrollmentServiceImplementation(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String insertEnrollment(InsertEnrollmentDto dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentNumber(dto.getStudentNumber());
        enrollment.setEnrollDate(dto.getEnrollmentDate());
        enrollment.setPeriodID(dto.getPeriodId());

        if (dto.getTransactionDate() != null)
            enrollment.setTransactionDate(dto.getTransactionDate());

        if (dto.getPaymentMethod() != null)
            enrollment.setPaymentMethod(dto.getPaymentMethod());

        if (dto.getFee() != null)
            enrollment.setFee(dto.getFee());

        enrollment.setStatus(dto.getStatus());

        repository.save(enrollment);
        return "Insert Success!!";
    }
}
