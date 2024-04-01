package com.jakhongir.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    @Before("execution(public void add*(com.jakhongir.springboot.demo.mycoolapp.entity.Employee, ..))")
    public void beforeAddAccount(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method" + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            System.out.println("Object " + object);
        }
        System.out.println("Before add account log something");
    }

//    @Before("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.*(..))")
//    public void beforeAnyMethodInDaoPackage() {
//        System.out.println("Before any method in dao package run this aspect logging !");
//    }

    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.get*(..))")
    private void getter() {
        System.out.println("has getter");
    }

    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.set*(..))")
    private void setter() {
        System.out.println("has setter");
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoSetterNoGetter() {
    }

//    @Before("forDaoPackageNoSetterNoGetter()")
//    public void performApiAnalysis() {
//        System.out.println("Perform api analysis !");
//    }

    @Before("forDaoPackageNoSetterNoGetter()")
    public void addingLogs() {
        System.out.println("Adding logs !");
    }
}
