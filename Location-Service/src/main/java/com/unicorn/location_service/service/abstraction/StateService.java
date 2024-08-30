package com.unicorn.location_service.service.abstraction;

import com.unicorn.location_service.dto.StateDto;

import java.util.List;

public interface StateService {
    List<StateDto> getStates(int page, Long countryId);
}
