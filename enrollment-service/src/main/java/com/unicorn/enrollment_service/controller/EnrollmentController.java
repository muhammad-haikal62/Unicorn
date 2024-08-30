package com.unicorn.enrollment_service.controller;

import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public ResponseEntity<Object> addEnrollment(
            @Valid @RequestBody InsertEnrollmentDto dto,
            BindingResult bindingResult
    ){
        try {
            if (bindingResult.hasErrors()){
                return ResponseEntity.unprocessableEntity().body(bindingResult.getAllErrors());
            }
            return ResponseEntity.ok().body(service.insertEnrollment(dto));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
