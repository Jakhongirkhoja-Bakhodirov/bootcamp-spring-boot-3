package com.jakhongir.springboot.demo.mycoolapp.service;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> findAll();

    Employee findById(int id);

    Employee updateOrCreate(Employee employee);

    void delete(int id);
}
