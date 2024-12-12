package com.hitham.aopdemo.dao;

import com.hitham.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account,boolean flag) {
        System.out.println(getClass()+": Doing DB WORK");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");

        return true;
    }
}
