package com.example.EEmployee.service;


import com.example.EEmployee.collection.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);

    Employee getEmployeeById(String id) throws Exception;

    List<Employee> getAllEmployees();

    void deleteAllEmployee();

    Employee deleteEmployee(String id) throws Exception;

    Employee findByEmail(String email);

    Employee updateEmployee(String id,Employee employee) throws Exception;
}
