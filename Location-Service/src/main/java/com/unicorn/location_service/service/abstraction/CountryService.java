package com.unicorn.location_service.service.abstraction;

import com.unicorn.location_service.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getCountries();
}
