package com.jakhongir.springboot.demo.mycoolapp.rest;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import com.jakhongir.springboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        System.out.println("employeeId " + employeeId);
        Employee employee = this.employeeService.findById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }
}
