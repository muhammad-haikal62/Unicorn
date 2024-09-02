package com.unicorn.subject_service.controller;

import com.unicorn.subject_service.dto.MajorGrid;
import com.unicorn.subject_service.dto.UpdateInsertMajor;
import com.unicorn.subject_service.entity.Major;
import com.unicorn.subject_service.service.MajorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            List<MajorGrid> majors = service.getMajors();
            return ResponseEntity.status(HttpStatus.OK).body(majors);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{majorId}")
    public ResponseEntity<Object> getMajorById(
            @PathVariable Integer majorId
    ){
        try{
            MajorGrid majorGrid = service.getMajorById(majorId);
            return ResponseEntity.status(HttpStatus.OK).body(majorGrid);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("editMajor")
    public ResponseEntity<Object> editMajor(
            @RequestParam(required = false) Integer majorId
    ){
        try {
            UpdateInsertMajor updateInsertMajor = service.editMajor(majorId);
            return ResponseEntity.status(HttpStatus.OK).body(updateInsertMajor);
        } catch (Exception ex){
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
