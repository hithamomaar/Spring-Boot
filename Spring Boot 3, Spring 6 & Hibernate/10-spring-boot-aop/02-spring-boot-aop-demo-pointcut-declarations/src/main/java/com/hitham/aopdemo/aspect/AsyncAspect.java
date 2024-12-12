package com.hitham.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class AsyncAspect {
    @Before("com.hitham.aopdemo.aspect.AopExpressions.DaoPackageNoGetSet()")
    public void logToCloudAsync() {
        System.out.println("\n=======>>> Logging to Cloud in async");
    }
}
