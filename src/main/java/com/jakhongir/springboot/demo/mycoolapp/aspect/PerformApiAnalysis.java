package com.jakhongir.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class PerformApiAnalysis {
    @Pointcut("execution(* com.jakhongir.springboot.demo.mycoolapp.dao.*.set*(..))")
    private void setter() {}

    @Before("setter()")
    public void performApiAnalysis() {
        System.out.println("Perform api analysis !");
    }
}
