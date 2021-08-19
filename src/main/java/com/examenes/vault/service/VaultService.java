package com.examenes.vault.service;

import com.examenes.vault.domain.Employee;
import com.examenes.vault.exception.RequestException;
import com.examenes.vault.mapper.DepartmentMapper;
import com.examenes.vault.mapper.EmployeeMapper;
import com.examenes.vault.repository.EmployeeRepository;
import com.examenes.vault.repository.model.EmployeeModel;
import com.examenes.vault.repository.model.JobModel;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VaultService {

    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        EmployeeModel employeeModel = EmployeeMapper.toModel(employee);

        List<EmployeeModel> listEmp = employeeRepository.findAll()
                .stream().filter(emp -> emp.getDepartment().getDepartmentId() == employeeModel.getDepartment().getDepartmentId()).collect(Collectors.toList());
        Long sumSalary = 0L;
        for (EmployeeModel e : listEmp) {
            sumSalary += e.getSalary();
        }
        Long avgSalary = sumSalary / listEmp.size();
        Date today = Date.from(Instant.now());
        if ((Calendar.DAY_OF_MONTH < 14 && avgSalary > 1000) || (Calendar.DAY_OF_MONTH > 14 && avgSalary > 1500)) {
            throw new RequestException("Denied", "denied", HttpStatus.CONFLICT.value());
        }
        EmployeeModel insertedEmployee = employeeRepository.save(employeeModel);
        return EmployeeMapper.toDomain(insertedEmployee, false);
    }

    public Employee get(Long id) {
        EmployeeModel employeeModel;
        try {
            employeeModel = employeeRepository.getById(id);
            return EmployeeMapper.toDomain(employeeModel, false);
        } catch (EntityNotFoundException e) {
            throw new RequestException("Employee not found", "not.found", HttpStatus.NOT_FOUND.value());
        }
    }

    public Employee getOptional(Long id) {
        Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);
        if (employeeModel.isPresent()) {
            return EmployeeMapper.toDomain(employeeModel.get(), false);
        }
        throw new RequestException("Employee not found", "not.found", HttpStatus.NOT_FOUND.value());
    }

    public List<Employee> findEmployees(Long jobId) {
        if (jobId == null) {
            return employeeRepository.findAll()
                    .stream().map((employeeModel -> EmployeeMapper.toDomain(employeeModel, true))) // map((EmployeeMapper::toDomain)) esta forma se puede utilizar con un solo parametro
                    .collect(Collectors.toList());
        }
        return employeeRepository.findAllByJob(new JobModel(jobId, null, null, null))
                .stream().map((employeeModel -> EmployeeMapper.toDomain(employeeModel, true))) // map((EmployeeMapper::toDomain)) esta forma se puede utilizar con un solo parametro
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
            updateFields(employee, employeeModel);
            return EmployeeMapper.toDomain(employeeRepository.save(employeeModel), false);
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
