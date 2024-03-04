package com.jakhongir.springboot.demo.mycoolapp.service;

import com.jakhongir.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.getAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee updateOrCreate(Employee employee) {
        return this.employeeDAO.updateOrCreate(employee);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.employeeDAO.delete(id);
    }
}
