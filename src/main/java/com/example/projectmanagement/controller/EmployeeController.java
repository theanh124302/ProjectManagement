package com.example.projectmanagement.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import com.example.projectmanagement.dto.CreateEmployee;
import com.example.projectmanagement.entity.Employee;
import com.example.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping()
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployee createEmployee) {
        if (!employeeService.isValidGender(createEmployee.getGender()) || !employeeService.isValidDateOfBirth(createEmployee.getDateOfBirth())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vui lòng nhập đúng giới tính và ngày tháng năm sinh");
        }
        return ResponseEntity.ok(employeeService.saveOrUpdateEmployee(createEmployee));
    }

    @PutMapping()
    public ResponseEntity<?> updateEmployee(@RequestBody CreateEmployee createEmployee) {
        if (!employeeService.isValidGender(createEmployee.getGender()) || !employeeService.isValidDateOfBirth(createEmployee.getDateOfBirth())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vui lòng nhập đúng giới tính và ngày tháng năm sinh");
        }
        return ResponseEntity.ok(employeeService.saveOrUpdateEmployee(createEmployee));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeByID(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Employee>> getEmployeeByName(@RequestParam String name, Pageable pageable) {
        return ResponseEntity.ok(employeeService.findEmployeesByName(name, pageable));
    }

}
