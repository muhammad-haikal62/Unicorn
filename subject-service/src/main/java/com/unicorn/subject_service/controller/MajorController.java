package com.unicorn.subject_service.controller;

import com.unicorn.subject_service.dto.MajorGrid;
import com.unicorn.subject_service.dto.UpdateInsertMajor;
import com.unicorn.subject_service.service.MajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("major")
public class MajorController {
    private final MajorService service;

    public MajorController(MajorService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getMajors(){
        try{
            MajorGrid majorGrid =
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("save")
    public ResponseEntity<Object> saveMajor(@RequestBody UpdateInsertMajor dto){
        try {
            service.save(dto);
            return ResponseEntity.ok(dto);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> deleteMajor(@RequestParam Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok(id);
        }catch (Exception ex){
            return ResponseEntity.ok(id);
        }
    }
}
