package com.unicorn.location_service.controller;

import com.unicorn.location_service.dto.StateDto;
import com.unicorn.location_service.service.abstraction.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class StateController {
    private StateService service;

    @Autowired
    public StateController(StateService service) {
        this.service = service;
    }

    @GetMapping("state")
    public ResponseEntity<Object> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Long countryId
    ){
        try {
            List<StateDto> states = service.getStates(page, countryId);
            return ResponseEntity.ok(states);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }


}
