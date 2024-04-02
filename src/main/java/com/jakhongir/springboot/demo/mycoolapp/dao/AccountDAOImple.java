package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDAOImple implements AccountDAO{

    private int balance;

    public int getBalance() {
        System.out.println("get balance");
        return balance;
    }

    @Override
    public List findAccounts() {
        System.out.println("find accounts from database");
        return null;
    }

    public void setBalance(int balance) {
        System.out.println("set balance");
        this.balance = balance;
    }

    @Override
    public void addAccount(Employee employee,boolean isActive) {
        System.out.println("Do adding to account");
    }
}
