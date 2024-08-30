package com.Student_Service.service;

import com.Student_Service.dto.StudentDto;
import com.Student_Service.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudentPage(Integer page);
    StudentDto getStudentByStudentNumber(String studentNumber);

    boolean editStudent(Integer studentNumber);
    boolean deleteStudent(Integer studentNumber);
}
