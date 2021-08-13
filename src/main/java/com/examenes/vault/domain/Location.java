package com.examenes.vault.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    Long locationId;
    String streetAddress;
    String postalCode;
    String city;
    String stateProvince;
    Country country;

}
