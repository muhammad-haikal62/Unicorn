package com.Student_Service.service.implemention;

import com.Student_Service.dto.StudentDto;
import com.Student_Service.entity.Student;
import com.Student_Service.repository.StudentRepository;
import com.Student_Service.service.StudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.LinkedList;
import java.util.List;

public class StudentServiceImplemention implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImplemention(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDto> getAllStudentPage(Integer page) {
        Pageable pageable = PageRequest.of(page-1, 5, Sort.by("id"));
        List<Student> students = repository.getStudentByPage(pageable);
        List<StudentDto> gridStudents = new LinkedList<>();
        for (var stu : students){
            StudentDto studentDto = new StudentDto();
            studentDto.setId(stu.getId());
            studentDto.setFirstName(stu.getFirstName());
            studentDto.setLastName(stu.getLastName());
            studentDto.setPenjurusan(stu.getPenjurusan());
            gridStudents.add(studentDto);
        }
        return gridStudents;
    }
}
