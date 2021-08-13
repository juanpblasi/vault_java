package com.examenes.vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDto {
    Long locationId;
    String streetAddress;
    String postalCode;
    String city;
    String stateProvince;
    CountryDto country;

}
