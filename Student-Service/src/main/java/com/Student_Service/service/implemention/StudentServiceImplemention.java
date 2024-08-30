package com.Student_Service.service.implemention;

import com.Student_Service.dto.StudentDto;
import com.Student_Service.dto.StudentInsertDto;
import com.Student_Service.entity.Student;
import com.Student_Service.repository.StudentRepository;
import com.Student_Service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.LinkedList;
import java.util.List;

public class StudentServiceImplemention implements StudentService {
    private final StudentRepository repository;

    @Autowired
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
            studentDto.setStudentNumber(stu.getStudentNumber());
            studentDto.setUsername(stu.getUsername());
            studentDto.setPassword(stu.getPassword());
            studentDto.setTitle(stu.getTitle());
            studentDto.setFirstName(stu.getFirstName());
            studentDto.setMiddleName(stu.getMiddleName());
            studentDto.setLastName(stu.getLastName());
            studentDto.setGender(stu.getGender());
            studentDto.setBirthDate(stu.getBirthDate());
            studentDto.setBirthCountryId(stu.getBirthCountryId());
            studentDto.setBirthCityId(stu.getBirthCityId());
            studentDto.setCitizenshipId(stu.getCitizenshipId());
            studentDto.setAddress(stu.getAddress());
            studentDto.setRegisterDate(stu.getRegisterDate());
            studentDto.setTotalCreditPoint(stu.getTotalCreditPoint());
            gridStudents.add(studentDto);
        }
        return gridStudents;
    }

    @Override
    public void saveStudent(StudentInsertDto dto) {
        Student student = new Student();
        student.setStudentNumber(dto.getStudentNumber());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        student.setTitle(dto.getTitle());
        student.setFirstName(dto.getFirstName());
        student.setMiddleName(dto.getMiddleName().isEmpty() ? null:dto.getMiddleName());
        student.setLastName(dto.getLastName().isEmpty() ? null:dto.getLastName());
        student.setGender(dto.getGender());
        student.setBirthDate(dto.getBirthDate());
        student.setBirthCountryId(dto.getBirthCountryId());
        student.setBirthCityId(dto.getBirthCityId());
        student.setCitizenshipId(dto.getCitizenshipId());
        student.setAddress(dto.getAddress());
        student.setRegisterDate(dto.getRegisterDate());
        student.setTotalCreditPoint(dto.getTotalCreditPoint());
        repository.save(student);
    }

    @Override
    public boolean editStudent(Integer studentNumber) {
//        saya ganteng
        return false;
    }

    @Override
    public boolean deleteStudent(Integer studentNumber) {
        return false;
    }
}
