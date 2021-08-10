package com.examenes.vault.mapper;

import com.examenes.vault.domain.Department;
import com.examenes.vault.repository.model.DepartmentModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DepartmentMapper {

    public static Department toDomain(DepartmentModel departmentModel){
        return new Department(departmentModel.getDepartmentId(), departmentModel.getDepartmentName(), departmentModel.getManagerId());

    }

    public static DepartmentModel toModel(Department department){
     return new DepartmentModel(department.getDepartmentId(), department.getDepartmentName(), department.getManagerId(), new ArrayList<>());
    }
}
