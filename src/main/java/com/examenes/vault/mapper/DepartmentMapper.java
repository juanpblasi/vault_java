package com.examenes.vault.mapper;

import com.examenes.vault.domain.Department;
import com.examenes.vault.dto.DepartmentDto;
import com.examenes.vault.repository.model.DepartmentModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DepartmentMapper {

    public static Department toDomain(DepartmentModel departmentModel) {
        return new Department(departmentModel.getDepartmentId(),
                departmentModel.getDepartmentName(),
                departmentModel.getManagerId(),
                LocationMapper.toDomain(departmentModel.getLocation())
        );

    }

    public static DepartmentModel toModel(Department department) {
        return new DepartmentModel(department.getDepartmentId(),
                department.getDepartmentName(),
                department.getManagerId(),
                LocationMapper.toModel(department.getLocation()),
                new ArrayList<>());
    }

    public static DepartmentDto toDto(Department department) {
        return new DepartmentDto(department.getDepartmentId(), department.getDepartmentName(), department.getManagerId(), LocationMapper.toDto(department.getLocation()));
    }

    public static Department toDomain(DepartmentDto departmentDto) {
        return new Department(departmentDto.getDepartmentId(), departmentDto.getDepartmentName(), departmentDto.getManagerId(), LocationMapper.toDomain(departmentDto.getLocationDto()));

    }

}
