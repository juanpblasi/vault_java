package com.examenes.vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
    private Long managerId;
    private LocationDto locationDto;
}
