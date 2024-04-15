package com.example.projectmanagement.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "project")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long leaderId;

//    @ManyToMany(cascade = CascadeType.ALL)
//    Set<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
