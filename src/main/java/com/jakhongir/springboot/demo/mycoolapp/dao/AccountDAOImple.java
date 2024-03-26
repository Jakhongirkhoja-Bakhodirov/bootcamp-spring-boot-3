package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImple implements AccountDAO{
    @Override
    public void addAccount(Employee employee,boolean isActive) {
        System.out.println("Do adding to account");
    }
}
