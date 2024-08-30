package com.unicorn.location_service.controller;

import com.unicorn.location_service.dto.CityDto;
import com.unicorn.location_service.service.abstraction.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {
    private final CityService service;

    @Autowired
    public CityController(CityService service){
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> get(
            @RequestParam(defaultValue = "1") int page
    ){
        try{
            List<CityDto> cities = service.getCities(page);
            return ResponseEntity.ok(cities);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
