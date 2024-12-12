package com.hitham.aopdemo.aspect;

import com.hitham.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class LoggingAspect {
    @Around("execution(* com.hitham.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint ProcPoint) throws Throwable {

        String method = ProcPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @Around on method " + method);

        long begin = System.currentTimeMillis();

        Object res = null;
        try {
            res = ProcPoint.proceed();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());

            throw ex;
        }
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Duration: " + duration / 1000.0 + " seconds");

        return res;
    }

    @After("execution(* com.hitham.aopdemo.dao.AccountDAO.findAccounts(..))")
    private void afterFinallyFindAccountAdvice(JoinPoint Point){
        String method = Point.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @After (finally) on method " + method);
    }


    @AfterThrowing(
            pointcut = "execution(* com.hitham.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exp"
    )
    public void afterThrowingFindAccount(JoinPoint Point, Throwable exp) {
        String method = Point.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterThrowing method " + method);

        System.out.println("\n=======>>> the exception is " + exp);

    }

    @AfterReturning(
            pointcut = "execution(* com.hitham.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "res"
    )
    public void AfterReturningFindAccounts(JoinPoint Point, List<Account> res) {
        String method = Point.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning on method " + method);

        System.out.println("\n=======>>> result is: " + res);

        convert(res);
    }

    private void convert(List<Account> res) {
        for (Account acc : res) {
            acc.setName(acc.getName().toUpperCase());
        }
    }

    @Before("com.hitham.aopdemo.aspect.AopExpressions.DaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(JoinPoint JPoint) {
        System.out.println("\n=======>>> Executing @Before advice");

        MethodSignature methodSign = (MethodSignature) JPoint.getSignature();
        System.out.println("Method: " + methodSign);

        Object[] args = JPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if(arg instanceof Account) {
                Account acc = (Account) arg;
                System.out.println("Account Name: "+acc.getName());
                System.out.println("Account Level: "+acc.getLevel());
            }
        }
    }
}