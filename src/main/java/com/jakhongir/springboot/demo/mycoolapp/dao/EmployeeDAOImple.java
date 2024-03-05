package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImple implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        System.out.println("Employee DAO Imple");
        TypedQuery<Employee> employees = this.entityManager.createQuery("FROM Employee order by id", Employee.class);
      //  System.out.println(employees.getResultList());
        return employees.getResultList();
    }

    @Override
    public Employee findById(int id) {
        System.out.println("id " + id);
        Employee employee = this.entityManager.find(Employee.class, id);
        System.out.println("Employee "+employee.toString());
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    @Transactional
    public Employee updateOrCreate(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        this.entityManager.remove(employee);
    }
}
