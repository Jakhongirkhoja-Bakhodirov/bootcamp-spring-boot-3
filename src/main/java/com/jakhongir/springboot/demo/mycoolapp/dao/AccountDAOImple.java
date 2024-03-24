package com.jakhongir.springboot.demo.mycoolapp.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAOImple implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println("Do adding to account");
    }
}
