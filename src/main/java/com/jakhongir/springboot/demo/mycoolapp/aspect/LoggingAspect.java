package com.jakhongir.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public void add*(com.jakhongir.springboot.demo.mycoolapp.entity.Employee, ..))")
    public void beforeAddAccount() {
        System.out.println("Before add account log something");
    }

//    @Before("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.*(..))")
//    public void beforeAnyMethodInDaoPackage() {
//        System.out.println("Before any method in dao package run this aspect logging !");
//    }

    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void performApiAnalysis() {
        System.out.println("Perform api analysis !");
    }

    @Before("forDaoPackage()")
    public void addingLogs() {
        System.out.println("Adding logs !");
    }
}
