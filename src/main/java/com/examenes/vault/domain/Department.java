package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    Long departmentId;
    String departmentName;
    Long managerId;

}
