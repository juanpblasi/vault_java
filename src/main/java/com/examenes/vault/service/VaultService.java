package com.examenes.vault.service;

import com.examenes.vault.domain.Employee;
import com.examenes.vault.exception.RequestException;
import com.examenes.vault.mapper.DepartmentMapper;
import com.examenes.vault.mapper.EmployeeMapper;
import com.examenes.vault.repository.EmployeeRepository;
import com.examenes.vault.repository.model.EmployeeModel;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VaultService {

    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        EmployeeModel employeeModel = EmployeeMapper.toModel(employee);
        EmployeeModel insertedEmployee = employeeRepository.save(employeeModel);
        return EmployeeMapper.toDomain(insertedEmployee);
    }

    public Employee get(Long id) {
        EmployeeModel employeeModel;
        try {
            employeeModel = employeeRepository.getById(id);
            return EmployeeMapper.toDomain(employeeModel);
        } catch (EntityNotFoundException e) {
            throw new RequestException("Employee not found", "not.found", HttpStatus.NOT_FOUND.value());
        }
    }

    public List<Employee> findEmployees() {
        return employeeRepository.findAll()
                .stream().map((EmployeeMapper::toDomain)) //map((employeeModel -> EmployeeMapper.toDomain(employeeModel)))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RequestException("Employee not found", "not.found", HttpStatus.NOT_FOUND.value());
        }

    }

    public Employee update(Long id, Employee employee) {
        EmployeeModel employeeModel;
        try {
            employeeModel = employeeRepository.getById(id);
            updateFields(employee,employeeModel);
            return EmployeeMapper.toDomain(employeeRepository.save(employeeModel));
        } catch (EntityNotFoundException e) {
            throw new RequestException("Employee not found", "not.found", HttpStatus.NOT_FOUND.value());
        }
    }

    private void updateFields(Employee employee, EmployeeModel employeeModel) {
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setDepartment(DepartmentMapper.toModel(employee.getDepartment()));
        employeeModel.setCommissionPct(employee.getCommissionPct());
        employeeModel.setHireDate(employee.getHireDate());
        employeeModel.setManagerId(employee.getManagerId());
        employeeModel.setPhoneNumber(employee.getPhoneNumber());
        employeeModel.setSalary(employee.getSalary());
    }
}
