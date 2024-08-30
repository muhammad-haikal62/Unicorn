package com.Student_Service.controller;

import com.Student_Service.dto.StudentUpsertDto;
import com.Student_Service.dto.StudentDto;
import com.Student_Service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/getStudentsPage")
    public ResponseEntity<Object> getStudentsByPage(@RequestParam Integer page){
        try{
            List<StudentDto> students = service.getAllStudentPage(page);
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @GetMapping("/getStudentByNumber")
    public ResponseEntity<Object> getStudentBystudentNumber(@RequestParam String studentNumber){
        try{
            StudentDto student = service.getStudentByStudentNumber(studentNumber);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }


    @GetMapping(value = {"/getStudentByFullName={fullName}"})
    public ResponseEntity<Object> getStudentByFullName(@PathVariable String fullName){
        try{
            var student = service.getStudentByFullName(fullName);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @GetMapping(value = {"/getStudentByCitizenshipID={citizenshipId}"})
    public ResponseEntity<Object> getStudentByCitizenshipID(@PathVariable Integer citizenshipId){
        try{
            List<StudentDto> students = service.getStudentByCitizenshipID(citizenshipId);
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Object> post(@RequestBody StudentUpsertDto dto){
        try{
            service.saveStudent(dto);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is Runtime Error");
        }
    }

    @GetMapping(value = {"/getCertificateByStudentNumber={studentNumber}"})
    public ResponseEntity<Object> getCertificateByStudentNumber(@PathVariable String studentNumber){
        try {
            var dto = service.getCertificate(studentNumber);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is Runtime Error");
        }
    }

    @GetMapping(value = {"/getStudentMajor"})
    public ResponseEntity<Object> getStudentMajor(@RequestParam String studentNumber){
        try {
            var dto = service.getMajorByStudentNumber(studentNumber);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is Runtime Error");
        }
    }

    @PostMapping("/editStudent")
    public ResponseEntity<Object> edit(@RequestBody StudentUpsertDto dto){
        try{
            service.editStudent(dto);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is Runtime Error");
        }
    }

    @GetMapping(value = {"/deleteStudent"})
    public ResponseEntity<Object> deleteStudent(@RequestParam String studentNumber){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteStudent(studentNumber));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is Runtime Error");
        }
    }
}
