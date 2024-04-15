package com.example.projectmanagement.dto;


import com.example.projectmanagement.dao.Role;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name ="employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    private Date dateOfBirth;

    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
