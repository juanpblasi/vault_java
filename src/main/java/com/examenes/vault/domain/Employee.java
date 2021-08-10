package com.examenes.vault.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
 EMPLOYEE_ID NUMBER (6) NOT NULL ,
 FIRST_NAME VARCHAR2 (20 BYTE) ,
 LAST_NAME VARCHAR2 (25 BYTE) NOT NULL ,
 EMAIL VARCHAR2 (25 BYTE) NOT NULL ,
 PHONE_NUMBER VARCHAR2 (20 BYTE) ,
 HIRE_DATE DATE NOT NULL ,
 JOB_ID VARCHAR2 (10 BYTE) NOT NULL ,
 SALARY NUMBER (8,2) ,
 COMMISSION_PCT NUMBER (2,2) ,
 MANAGER_ID NUMBER (6) ,
 DEPARTMENT_ID NUMBER (4)
 */
@Data
@AllArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Long salary;
    private Long commissionPct;
    private Long managerId;
    private Department department;
}


