package com.unicorn.subject_service.controller;

import com.unicorn.subject_service.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getSubjects(@RequestParam(defaultValue = "0")Integer subjectId,
                                                        @RequestParam(defaultValue = "0")Integer majorId,
                                                        @RequestParam(defaultValue = "0")Integer prerequisiteId)
    {
        try {
            return ResponseEntity.ok(service.getSubject(subjectId,majorId,prerequisiteId));
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body("error");
        }
    }
}
