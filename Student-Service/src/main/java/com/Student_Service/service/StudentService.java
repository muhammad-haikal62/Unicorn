package com.Student_Service.service;

import com.Student_Service.dto.CertificateDto;
import com.Student_Service.dto.StudentDto;
import com.Student_Service.dto.StudentMajorDto;
import com.Student_Service.dto.StudentUpsertDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent(Integer page, Integer citizenshipId);

    void saveStudent(StudentUpsertDto studentUpsertDto);
    Integer totalPage();
    void editStudent(StudentUpsertDto dto);
    void deleteStudent(String studentNumber);
    StudentDto getStudentByStudentNumber(String studentNumber);
    List<StudentMajorDto> getMajorByStudentNumber(String studentNumber);
    StudentDto getStudentByFullName(String fullName);
    CertificateDto getCertificate(String studentNumber);
}
