package com.example.Employee.Controller;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.FindException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees")
    public String getEmployees(Model model){
        model.addAttribute("listEmployees",employeeService.getEmployees());
        return "index";
    }

    @GetMapping("/employeeForm")
    public String addEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

}
