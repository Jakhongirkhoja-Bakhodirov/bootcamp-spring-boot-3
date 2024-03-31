package com.jakhongir.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(public void add*(com.jakhongir.springboot.demo.mycoolapp.entity.Employee,boolean isActive))")
//    public void beforeAddAccount() {
//        System.out.println("Before add account log something");
//    }

    @Before("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.*(..))")
    public void beforeAnyMethodInDaoPackage() {
        System.out.println("Before any method in dao package run this aspect logging !");
    }
}
