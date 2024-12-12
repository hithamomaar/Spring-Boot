package com.hitham.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.hitham.aopdemo.dao.*.*(..))")
    public void DaoPackage() {
    }

    @Pointcut("execution(* com.hitham.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.hitham.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("DaoPackage() && !(getter() || setter())")
    public void DaoPackageNoGetSet() {
    }
}
