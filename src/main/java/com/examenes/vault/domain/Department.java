package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    private Long departmentId;
    private String departmentName;
    private Long managerId;
    private Location location;

}
