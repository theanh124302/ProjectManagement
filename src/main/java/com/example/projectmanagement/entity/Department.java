package com.example.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name ="department")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Project> projects;

}
