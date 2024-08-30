package com.Student_Service.controller;

import com.Student_Service.dto.StudentInsertDto;
import com.Student_Service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = {"/getStudentByFullName={fullName}"})
    public ResponseEntity<Object> getStudentByFullName(@PathVariable String fullName){
        try{
            var student= service.getStudentByFullName(fullName);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @GetMapping(value = {"/getStudentByCitizenshipID={citizenshipId}"})
    public ResponseEntity<Object> getStudentByCitizenshipID(@PathVariable Integer citizenshipId){
        try{
            var student= service.getStudentByCitizenshipID(citizenshipId);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Object> post(@RequestBody StudentInsertDto dto){
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
}
