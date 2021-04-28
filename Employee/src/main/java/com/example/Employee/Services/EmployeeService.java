package com.example.Employee.Services;

import com.example.Employee.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public void saveEmployee(Employee employee);
}
