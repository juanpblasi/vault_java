package com.examenes.vault.controller;

import com.examenes.vault.domain.Employee;
import com.examenes.vault.dto.EmployeeDto;
import com.examenes.vault.mapper.EmployeeMapper;
import com.examenes.vault.service.VaultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class VaultController {
    private VaultService vaultService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) throws ParseException {
        Employee employee = EmployeeMapper.toDomain(employeeDto);
        Employee insertedEmployee = vaultService.create(employee);
        return EmployeeMapper.toDto(insertedEmployee, false);
    }

    @GetMapping("/{id}") // Esto lo que hace es agregar en la URI el ID para cuado quiera obtener un employee via el id
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto get(@PathVariable Long id) { //@PathVariable extraer variable de lo que ponga como URI
        return EmployeeMapper.toDto(vaultService.get(id), false);
    }

    //
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findEmployees(@Nullable @RequestParam Long jobId) { // get es uno solo y muchos se usa find
        return vaultService.findEmployees(jobId)
                .stream().map((employee -> EmployeeMapper.toDto(employee, true)))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        vaultService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200
    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws ParseException {
        Employee employee = EmployeeMapper.toDomain(employeeDto);
        return EmployeeMapper.toDto(vaultService.update(id, employee),false);
    }
}
