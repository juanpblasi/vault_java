package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Country {
    private Long countryId;
    private String countryName;
    private Region region;

}
