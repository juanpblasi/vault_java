package com.examenes.vault.mapper;

import com.examenes.vault.domain.Location;
import com.examenes.vault.dto.LocationDto;
import com.examenes.vault.repository.model.LocationModel;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public static Location toDomain(LocationDto locationDto) {

        return new Location(locationDto.getLocationId(),
                locationDto.getStreetAddress(),
                locationDto.getPostalCode(),
                locationDto.getCity(),
                locationDto.getStateProvince(),
                CountryMapper.toDomain(locationDto.getCountry())
        );
    }

    public static LocationDto toDto(Location location) {
        return new LocationDto(location.getLocationId(),
                location.getStreetAddress(),
                location.getPostalCode(),
                location.getCity(),
                location.getStateProvince(),
                CountryMapper.toDto(location.getCountry())
        );
    }

    public static Location toDomain(LocationModel locationModel) {
        return new Location(locationModel.getLocationId(),
                locationModel.getStreetAddress(),
                locationModel.getPostalCode(),
                locationModel.getCity(),
                locationModel.getStateProvince(),
                CountryMapper.toDomain(locationModel.getCountry())
        );
    }

    public static LocationModel toModel(Location location) {
        return new LocationModel(
                location.getLocationId(),
                location.getStreetAddress(),
                location.getPostalCode(),
                location.getCity(),
                location.getStateProvince(),
                CountryMapper.toModel(location.getCountry())
        );
    }


}
