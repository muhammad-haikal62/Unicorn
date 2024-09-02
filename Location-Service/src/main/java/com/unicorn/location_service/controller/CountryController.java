package com.unicorn.location_service.controller;

import com.unicorn.location_service.service.abstraction.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/country")
public class CountryController {
    private final CountryService service;

    @Autowired
    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getCountries(){
        try {
            return ResponseEntity.ok(this.service.getCountries());
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body("Runtime Error");
        }
    }
}
