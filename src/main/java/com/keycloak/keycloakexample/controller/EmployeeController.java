package com.keycloak.keycloakexample.controller;

import com.keycloak.keycloakexample.entity.Employee;
import com.keycloak.keycloakexample.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // it's used by admin
    @PostMapping
    ResponseEntity<Employee> addEmployee(Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    // it's used for all roles
    @GetMapping("/{id}")
    @RolesAllowed("user")
    ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // it's used for admin
    @GetMapping
    @RolesAllowed("admin")
    ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
