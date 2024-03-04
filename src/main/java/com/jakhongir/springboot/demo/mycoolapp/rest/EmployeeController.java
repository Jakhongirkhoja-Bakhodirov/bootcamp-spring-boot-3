package com.jakhongir.springboot.demo.mycoolapp.rest;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import com.jakhongir.springboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }
}
