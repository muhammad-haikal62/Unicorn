package com.Student_Service.service;

import com.Student_Service.dto.CertificateDto;
import com.Student_Service.dto.StudentDto;
import com.Student_Service.dto.StudentMajorDto;
import com.Student_Service.dto.StudentUpsertDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudentPage(Integer page);

    void saveStudent(StudentUpsertDto studentUpsertDto);
    Integer totalPage();
    void editStudent(StudentUpsertDto dto);
    String deleteStudent(String studentNumber);
    StudentDto getStudentByStudentNumber(String studentNumber);
    List<StudentMajorDto> getMajorByStudentNumber(String studentNumber);
    StudentDto getStudentByFullName(String fullName);
    List<StudentDto> getStudentByCitizenshipID(Integer citizenshipId);
    CertificateDto getCertificate(String studentNumber);
}
