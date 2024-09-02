package com.unicorn.enrollment_service.service;

import com.unicorn.enrollment_service.dto.EnrollmentDto;
import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.dto.PeriodByEnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    String insertEnrollment(InsertEnrollmentDto dto);
    List<EnrollmentDto> getEnrollmentByPagination(Integer page);
    PeriodByEnrollmentDto getPeriodByEnrollment(Integer id);
    EnrollmentDto getEnrollmentById(Integer id);
    List<EnrollmentDto> getEnrollmentBySubjectId(Integer subjectId);
    List<EnrollmentDto> getEnrollmentByMajorId(Integer majorId);
}
