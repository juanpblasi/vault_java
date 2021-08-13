package com.examenes.vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDto {
    Long countryId;
    String countryName;
    RegionDto region;

}
