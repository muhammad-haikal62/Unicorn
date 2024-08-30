package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.dto.PeriodByEnrollmentDto;

public interface EnrollmentService {
    String insertEnrollment(InsertEnrollmentDto dto);
    PeriodByEnrollmentDto getPeriodByEnrollment(Integer id);
}
