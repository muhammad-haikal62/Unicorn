package com.Student_Service.service;

import com.Student_Service.dto.StudentDto;
import com.Student_Service.dto.StudentInsertDto;
import com.Student_Service.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudentPage(Integer page);

    void saveStudent(StudentInsertDto studentInsertDto);
    Integer totalPage();
    boolean editStudent(String studentNumber);
    boolean deleteStudent(String studentNumber);
    StudentDto getStudentByStudentNumber(String studentNumber);
}
