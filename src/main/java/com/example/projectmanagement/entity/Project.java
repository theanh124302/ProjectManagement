package com.example.projectmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
