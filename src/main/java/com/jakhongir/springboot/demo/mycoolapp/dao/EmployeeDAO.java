package com.jakhongir.springboot.demo.mycoolapp.dao;

import java.util.List;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee findById(int id);

    Employee updateOrCreate(Employee employee);

    void delete(int id);
}
