package com.Student_Service.service;

import com.Student_Service.dto.StudentDto;
import com.Student_Service.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudentPage(Integer page);
    Integer totalPage();
    boolean editStudent(String studentNumber);
    boolean deleteStudent(String studentNumber);
    StudentDto getStudentByStudentNumber(String studentNumber);
}
