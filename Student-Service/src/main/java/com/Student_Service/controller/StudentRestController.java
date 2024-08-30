package com.Student_Service.controller;

import com.Student_Service.dto.StudentInsertDto;
import com.Student_Service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService service) {
        this.service = service;
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
}
