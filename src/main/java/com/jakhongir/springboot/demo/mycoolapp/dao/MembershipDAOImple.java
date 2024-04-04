package com.jakhongir.springboot.demo.mycoolapp.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAOImple implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println("Do adding to account on Membership");
    } 
}