package com.examenes.vault.repository;

import com.examenes.vault.domain.Job;
import com.examenes.vault.repository.model.EmployeeModel;
import com.examenes.vault.repository.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    List<EmployeeModel> findAllByJob (JobModel job);
}


