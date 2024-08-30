package com.unicorn.location_service.service.implementation;

import com.unicorn.location_service.dto.StateDto;
import com.unicorn.location_service.entity.State;
import com.unicorn.location_service.repository.StateRepository;
import com.unicorn.location_service.service.abstraction.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImplementation implements StateService {
    private final StateRepository repository;
    private final Integer rowInPage = 5;

    @Autowired
    public StateServiceImplementation(StateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StateDto> getStates(int page, Integer countryId){
        Pageable pagination = PageRequest.of(page - 1, rowInPage);

        return repository.getStates(pagination, countryId);
    };

}
