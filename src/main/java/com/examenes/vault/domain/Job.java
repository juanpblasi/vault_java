package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private Long jobId;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
}
