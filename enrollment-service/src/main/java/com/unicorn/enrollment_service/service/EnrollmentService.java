package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;

public interface EnrollmentService {
    String insertEnrollment(InsertEnrollmentDto dto);
}
