package com.examenes.vault.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="department_id")
    Long departmentId;
    @Column(name="department_name")
    String departmentName;
    @Column(name="manager_id")
     Long managerId;
    @OneToMany()
    List<EmployeeModel> employees;

}
