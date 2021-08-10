package com.examenes.vault.dto;

import com.examenes.vault.domain.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @NotNull
    private String hireDate;
    private String jobId;
    private Long salary;
    private Long commissionPct;
    private Long managerId;
    @NotNull
    private Department department;
}
