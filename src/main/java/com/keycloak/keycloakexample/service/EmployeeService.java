package com.keycloak.keycloakexample.service;

import com.keycloak.keycloakexample.entity.Employee;
import com.keycloak.keycloakexample.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
         Employee savedEmp = employeeRepository.save(employee);
         return savedEmp;
    }

    public Employee getEmployeeById(Long id) throws Exception {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new Exception("user not found"));
        return emp;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
}
