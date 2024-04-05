package com.jakhongir.springboot.demo.mycoolapp.aspect;

import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.findAccounts(..))")
    private void findAccountLog() {
    }

    @AfterReturning(pointcut = "findAccountLog()", returning = "result")
    public void addingLogsAfterFindAccount(JoinPoint joinPoint, List<Employee> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning on method: " + method);
        System.out.println("Result" + result);
        System.out.println("after returning");
    }

    private void convertEmployeeFirstNameToUpperCase(List<Employee> result) {
        for (Employee employee : result) {
            System.out.println(employee);
            String upperFirstName = employee.getFirstName().toUpperCase();
            employee.setFirstName(upperFirstName);
            System.out.println(employee);
        }
    }

    @Pointcut("execution(public * com.jakhongir.springboot.demo.mycoolapp.dao.*.findAccounts(..))")
    private void hasExceptionToLogFindAccounts() {
    }

    @AfterThrowing(pointcut = "hasExceptionToLogFindAccounts()", throwing = "exception")
    public void logExceptionOnFindAccounts(JoinPoint joinPoint, Throwable exception) {
        System.out.println("More about exception" + exception.toString());
    }
}
