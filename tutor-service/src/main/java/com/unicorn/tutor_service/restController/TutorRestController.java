package com.unicorn.tutor_service.restController;

import com.unicorn.tutor_service.dto.TutorGridDto;
import com.unicorn.tutor_service.dto.UpdateInsertTutor;
import com.unicorn.tutor_service.service.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tutor")
public class TutorRestController {
    private final TutorService service;
    @Autowired
    public TutorRestController(TutorService service) {
        this.service = service;
    }

    @GetMapping("/{page}")
    public ResponseEntity<Object> find(
            @PathVariable int page
    ){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAllTutor(page));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<Object> purchase(
            @RequestBody UpdateInsertTutor updateInsertTutor
            ) {
        try {
            service.save(updateInsertTutor);
            return ResponseEntity.status(HttpStatus.OK).body("saved");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to save new tutor Data");
        }
    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(
            @RequestBody String staffNumber
    ) {
        try {
            service.delete(staffNumber);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to delete tutor Data");
        }
    }
}
