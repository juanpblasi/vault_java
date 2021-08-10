package com.examenes.vault.unit.service;


import com.examenes.vault.domain.Department;
import com.examenes.vault.domain.Employee;
import com.examenes.vault.repository.EmployeeRepository;
import com.examenes.vault.repository.model.DepartmentModel;
import com.examenes.vault.repository.model.EmployeeModel;
import com.examenes.vault.service.VaultService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

public class VaultServiceTest {

    private final EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
    private final VaultService vaultService = new VaultService(employeeRepository);

    @Test
    public void createEmployee() {
        // Employee -- no es nada
        // Employee.class -- es una clase
        // Employee employee = new Employee() -- sentencia que devuelve void
        // new Employee() -- esto es una instancia
        EmployeeModel employeeModel = new EmployeeModel();
        DepartmentModel departmentModel = new DepartmentModel();
        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employeeModel);
        Employee employee = new Employee(
                1L,
                "Juan",
                "Blasi",
                "juan@gmail.com",
                "1130714046",
                new Date(),
                "123",
                123445L,
                1235L,
                10L,
                new Department(1L,"Acceso",1L));
        Employee e  = vaultService.create(employee);
        Assertions.assertNotNull(e);
    }
}
