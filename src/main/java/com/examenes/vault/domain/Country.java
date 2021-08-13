package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Country {
    Long countryId;
    String countryName;
    Region region;

}
