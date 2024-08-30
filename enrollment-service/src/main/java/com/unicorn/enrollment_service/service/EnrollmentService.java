package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.EnrollmentDto;
import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    String insertEnrollment(InsertEnrollmentDto dto);
    List<EnrollmentDto> getEnrollmentByPagination(Integer page);
}
