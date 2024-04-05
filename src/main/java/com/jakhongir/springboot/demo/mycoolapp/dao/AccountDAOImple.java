package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAOImple implements AccountDAO {

    private int balance;

    public int getBalance() {
        System.out.println("get balance");
        return balance;
    }

    @Override
    public List findAccounts(boolean isActive) throws Exception {
        if (isActive == false) {
            throw new RuntimeException("Somthing went wrong");
        }

        Employee employee1 = new Employee("John", "Sally", "john@gmail.com", "accountant");
        Employee employee2 = new Employee("Smith", "Sally", "smith@gmail.com", "accountant");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        System.out.println("find accounts from database");
        return employeeList;

    }

    public void setBalance(int balance) {
        System.out.println("set balance");
        this.balance = balance;
    }

    @Override
    public void addAccount(Employee employee, boolean isActive) {
        System.out.println("Do adding to account");
    }
}
