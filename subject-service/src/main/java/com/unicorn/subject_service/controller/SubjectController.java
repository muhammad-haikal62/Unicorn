package com.unicorn.subject_service.controller;

import com.unicorn.subject_service.dto.SubjectSaveDto;
import com.unicorn.subject_service.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject-api")
public class SubjectController{
    private final SubjectService service;

    public SubjectController(SubjectService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Object> post(
            @Valid @RequestBody SubjectSaveDto dto,
            BindingResult bindingResult){
        try {
            if (!bindingResult.hasErrors()){
                service.save(dto);
                var bodies = dto.getId() + " berhasil diupdate";
                return ResponseEntity.status(HttpStatus.OK).body(bodies);
            }else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getAllErrors());
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RUNTIME ERROR");
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).
                    body("Shipment " + id + " berhasil dihapus");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RUNTIME ERROR");
        }
    }
}
