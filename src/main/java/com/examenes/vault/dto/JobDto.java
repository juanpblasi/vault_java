package com.examenes.vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobDto {
    private Long jobId;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
}
