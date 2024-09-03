package com.unicorn.location_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryDto {
    private Long id;
    private String sortName;
    private String name;
    private Integer phoneCode;
}
