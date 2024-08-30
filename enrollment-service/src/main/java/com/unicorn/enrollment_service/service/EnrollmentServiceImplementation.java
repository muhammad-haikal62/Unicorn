package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.EnrollmentDto;
import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.dto.PeriodByEnrollmentDto;
import com.unicorn.enrollment_service.entity.Enrollment;
import com.unicorn.enrollment_service.entity.Period;
import com.unicorn.enrollment_service.repository.EnrollmentRepository;
import com.unicorn.enrollment_service.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImplementation implements EnrollmentService {
    private final EnrollmentRepository repository;
    private final int rowInPage = 10;
    private final PeriodRepository periodRepository;

    @Autowired
    public EnrollmentServiceImplementation(EnrollmentRepository repository, PeriodRepository periodRepository) {
        this.repository = repository;
        this.periodRepository = periodRepository;
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

    @Override
    public List<EnrollmentDto> getEnrollmentByPagination(Integer page) {
        Pageable pageable = PageRequest.of(page - 1, rowInPage);
        return repository.getByPage(pageable);
    public PeriodByEnrollmentDto getPeriodByEnrollment(Integer id) {
        Period period = periodRepository.getPeriodByEnrollment(id);
        PeriodByEnrollmentDto periodDto = new PeriodByEnrollmentDto();
        periodDto.setPeriodId(period.getId());
        periodDto.setCompetencyId(period.getCompetencyId());
        periodDto.setStartDate(period.getStartDate());
        periodDto.setEndDate(period.getEndDate());
        return periodDto;
    }
}
