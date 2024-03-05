package com.jakhongir.springboot.demo.mycoolapp.repositories;

import com.jakhongir.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepository {

    private EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }


    @Transactional
    public Employee updateOrCreate(Employee employee) {
        return this.entityManager.merge(employee);
    }


    public List<Employee> getAll() {
        TypedQuery<Employee> employees = this.entityManager.createQuery("FROM Employee", Employee.class);
        return employees.getResultList();
    }



    @Transactional
    public void delete(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
