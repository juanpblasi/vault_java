package com.examenes.vault.mapper;

import com.examenes.vault.domain.Employee;
import com.examenes.vault.dto.EmployeeDto;
import com.examenes.vault.repository.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EmployeeMapper {

    public static Employee toDomain(EmployeeDto employeeDto) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                sdf.parse(employeeDto.getHireDate()),
                employeeDto.getJobId(),
                employeeDto.getSalary(),
                employeeDto.getCommissionPct(),
                employeeDto.getManagerId(),
                DepartmentMapper.toDomain(employeeDto.getDepartmentDto())
        );
    }

    public static EmployeeModel toModel(Employee employee) {
        return new EmployeeModel(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobId(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employee.getManagerId(),
                DepartmentMapper.toModel(employee.getDepartment())
        );
    }

    public static Employee toDomain(EmployeeModel employeeModel, boolean showFullInfo) {
        return new Employee(employeeModel.getId(),
                employeeModel.getFirstName(),
                employeeModel.getLastName(),
                employeeModel.getEmail(),
                employeeModel.getPhoneNumber(),
                employeeModel.getHireDate(),
                employeeModel.getJobId(),
                employeeModel.getSalary(),
                employeeModel.getCommissionPct(),
                employeeModel.getManagerId(),
                showFullInfo ? DepartmentMapper.toDomain(employeeModel.getDepartment()) : null
        );
    }

    public static EmployeeDto toDto(Employee employee, boolean showFullInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new EmployeeDto(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                sdf.format(employee.getHireDate()),
                employee.getJobId(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employee.getManagerId(),
                showFullInfo ?DepartmentMapper.toDto(employee.getDepartment()) : null
        );
    }
}
