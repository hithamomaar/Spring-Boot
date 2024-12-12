package com.hitham.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    //  to match a method on a specific class
//    @Before("execution(public void com.hitham.aopdemo.dao.AccountDAO.addAccount())")

//    // match method start with add
//    @Before("execution(public void add*())")

//    // match any return type
//    @Before("execution(* add*())")

    @Before("execution(* com.hitham.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Executing @Before advice");


    }
}
