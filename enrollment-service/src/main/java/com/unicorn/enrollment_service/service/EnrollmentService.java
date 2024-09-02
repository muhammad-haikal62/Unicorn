package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.EnrollmentDto;
import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.dto.PeriodByEnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    String insertEnrollment(InsertEnrollmentDto dto);
    List<EnrollmentDto> getEnrollment( Integer id, Integer majorId, Integer subjectId, Integer page);
    PeriodByEnrollmentDto getPeriodByEnrollment(Integer id);
}
