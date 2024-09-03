package com.unicorn.subject_service.controller;

import com.unicorn.subject_service.dto.SubjectSaveDto;
import com.unicorn.subject_service.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getSubjects(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "0") Integer subjectId,
                                              @RequestParam(defaultValue = "0") Integer majorId,
                                              @RequestParam(defaultValue = "0") Integer prerequisiteId) {
        try {
            return ResponseEntity.ok(service.getSubject(page, subjectId, majorId, prerequisiteId));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body("error");

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> post (
            @Valid @RequestBody SubjectSaveDto dto,
            BindingResult bindingResult){
        try {
            if (!bindingResult.hasErrors()) {
                service.save(dto);
                var bodies = dto.getId() + " berhasil disave";
                return ResponseEntity.status(HttpStatus.OK).body(bodies);
            } else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RUNTIME ERROR");
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Object> delete (@RequestParam(name = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).
                    body("subject " + id + " berhasil dihapus");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RUNTIME ERROR");
        }
    }
}