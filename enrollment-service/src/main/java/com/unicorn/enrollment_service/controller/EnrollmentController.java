package com.unicorn.enrollment_service.controller;

import com.unicorn.enrollment_service.dto.InsertEnrollmentDto;
import com.unicorn.enrollment_service.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollment")
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

    @GetMapping("page")
    public ResponseEntity<Object> getEnrollment(@RequestParam(defaultValue = "1") Integer page) {
        try {
            return ResponseEntity.ok(service.getEnrollmentByPagination(page));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal Server Error");
        }
    }
    @GetMapping("period")
    public ResponseEntity<Object> getPeriod(
            @RequestParam Integer id
    ){
        try {
            var detail = service.getPeriodByEnrollment(id);
            return ResponseEntity.ok(detail);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getEnrollmentById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(service.getEnrollmentById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal Server Error");
        }
    }

    @GetMapping("majorId")
    public ResponseEntity<Object> getEnrollmentByMajorId(
            @RequestParam(required = false)
                    Integer majorId
    ){
        try {
            return ResponseEntity.ok(service.getEnrollmentByMajorId(majorId));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("subjectId")
    public ResponseEntity<Object> getEnrollmentBySubjectId(
            @RequestParam(required = false)
                    Integer subjectId
    ){
        try {
            return ResponseEntity.ok(service.getEnrollmentBySubjectId(subjectId));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
