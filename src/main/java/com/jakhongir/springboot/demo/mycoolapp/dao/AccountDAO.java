package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;

public interface AccountDAO {
    void addAccount(Employee employee,boolean isActive);

    public void setBalance(int balance);

    public int getBalance();
}
