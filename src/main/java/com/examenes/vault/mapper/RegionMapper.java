package com.examenes.vault.mapper;

import com.examenes.vault.domain.Region;
import com.examenes.vault.dto.RegionDto;
import com.examenes.vault.repository.model.RegionModel;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {
    public static Region toDomain(RegionDto regionDto) {
        return new Region(regionDto.getRegionId(), regionDto.getRegionName());
    }

    public static Region toDomain(RegionModel regionModel) {
        return new Region(regionModel.getRegionId(), regionModel.getRegionName());
    }

    public static RegionDto toDto(Region region) {
        return new RegionDto(region.getRegionId(), region.getRegionName());
    }

    public static RegionModel toModel(Region region) {
        return new RegionModel(region.getRegionId(), region.getRegionName());
    }
}
