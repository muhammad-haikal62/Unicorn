package com.unicorn.location_service.service.implementation;

import com.unicorn.location_service.dto.CityDto;
import com.unicorn.location_service.repository.CityRepository;
import com.unicorn.location_service.service.abstraction.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImplementation implements CityService {
    private final CityRepository repository;
    private final Integer rowInPage = 5;

    @Autowired
    public CityServiceImplementation(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CityDto> getCities(int page, Long stateId){
        Pageable pagination = PageRequest.of(page - 1, rowInPage);
        return repository.getCities(pagination, stateId);
    };

}
