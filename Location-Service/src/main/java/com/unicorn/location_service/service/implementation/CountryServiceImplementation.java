package com.unicorn.location_service.service.implementation;

import com.unicorn.location_service.dto.CountryDto;
import com.unicorn.location_service.repository.CountryRepository;
import com.unicorn.location_service.service.abstraction.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryServiceImplementation(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CountryDto> getCountries(){
        return repository.getAll();
    }
}
