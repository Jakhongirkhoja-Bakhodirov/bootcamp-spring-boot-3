package com.jakhongir.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public void com.jakhongir.springboot.demo.mycoolapp.dao.AccountDAO.addAccount())")
    public void beforeAddAccount() {
        System.out.println("Before add account log something");
    }
}
