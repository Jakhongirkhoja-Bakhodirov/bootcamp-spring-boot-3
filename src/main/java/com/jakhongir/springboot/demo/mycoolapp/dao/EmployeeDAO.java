package com.jakhongir.springboot.demo.mycoolapp.dao;

import java.util.List;
import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee findById(int id);

    void save(Employee student);

    void update(Employee student);

    void delete(int id);
}
