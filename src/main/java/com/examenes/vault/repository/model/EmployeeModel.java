package com.examenes.vault.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "commission_pct")
    private Long commissionPct;

    @Column(name = "manager_id")
    private Long managerId;
    @ManyToOne(targetEntity = DepartmentModel.class,cascade = CascadeType.ALL)
    @JoinColumn(name="department_id", nullable=false, updatable=false)
    private DepartmentModel department;

}

