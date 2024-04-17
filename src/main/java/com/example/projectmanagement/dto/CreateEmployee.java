package com.example.projectmanagement.dto;

import com.example.projectmanagement.entity.Department;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateEmployee {
    private Long department_id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private Department department;
}
