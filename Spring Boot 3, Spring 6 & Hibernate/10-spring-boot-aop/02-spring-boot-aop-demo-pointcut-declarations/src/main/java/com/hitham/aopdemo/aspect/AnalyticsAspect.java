package com.hitham.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class AnalyticsAspect {
    @Before("com.hitham.aopdemo.aspect.AopExpressions.DaoPackageNoGetSet()")
    public void performAnalytics() {
        System.out.println("\n=======>>> Performing analytics");
    }
}
