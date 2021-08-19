package com.examenes.vault.mapper;

import com.examenes.vault.domain.Job;
import com.examenes.vault.dto.JobDto;
import com.examenes.vault.repository.model.JobModel;

public class JobMapper {

    public static Job toDomain(JobDto jobDto) {
        return new Job(jobDto.getJobId(), jobDto.getJobTitle(), jobDto.getMinSalary(), jobDto.getMaxSalary());
    }

    public static JobDto toDto(Job job) {
        return new JobDto(job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
    }

    public static JobModel toModel(Job job){
        return new JobModel(job.getJobId(), job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
    }

    public static Job toDomain(JobModel jobModel) {
        return new Job(jobModel.getJobId(), jobModel.getJobTitle(), jobModel.getMinSalary(), jobModel.getMaxSalary());
    }


}
