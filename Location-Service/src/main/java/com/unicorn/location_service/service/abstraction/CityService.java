package com.unicorn.location_service.service.abstraction;

import com.unicorn.location_service.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getCities(int page);
}
