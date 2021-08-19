package com.examenes.vault.mapper;


import com.examenes.vault.domain.Country;
import com.examenes.vault.dto.CountryDto;
import com.examenes.vault.repository.model.CountryModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CountryMapper {

    public static Country toDomain(CountryDto countryDto) {
        return new Country(countryDto.getCountryId(),
                countryDto.getCountryName(),
                RegionMapper.toDomain(countryDto.getRegion()));
    }

    public static Country toDomain(CountryModel countryModel) {
        return new Country(countryModel.getCountryId(),
                countryModel.getCountryName(),
                RegionMapper.toDomain(countryModel.getRegion()));
    }

    public static CountryDto toDto(Country country) {
        return new CountryDto(country.getCountryId(),
                country.getCountryName(),
                RegionMapper.toDto(country.getRegion()));
    }

    public static CountryModel toModel(Country country) {
        return new CountryModel(country.getCountryId(),
                country.getCountryName(),
                RegionMapper.toModel(country.getRegion()),
                new ArrayList<>());
    }
}
