package com.examenes.vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {
    Long departmentId;
    String departmentName;
    Long managerId;
    LocationDto locationDto;
}
