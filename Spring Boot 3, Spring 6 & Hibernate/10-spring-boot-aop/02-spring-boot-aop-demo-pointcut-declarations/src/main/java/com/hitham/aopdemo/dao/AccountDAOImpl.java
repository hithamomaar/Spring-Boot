package com.hitham.aopdemo.dao;

import com.hitham.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;

    private String code;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean b) {

        if(b == true){
            throw new RuntimeException("Ex Test");
        }

        List<Account> accs = new ArrayList<>();

        Account acc1 = new Account("Hitham", "Expert");
        Account acc2 = new Account("Yahia", "Expert");
        Account acc3 = new Account("Sharaf", "Pupil");

        accs.add(acc1);
        accs.add(acc2);
        accs.add(acc3);

        return accs;
    }

    @Override
    public void addAccount(Account account,boolean flag) {
        System.out.println(getClass()+": Doing DB WORK");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass()+": getname()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setname()");
        this.name = name;
    }

    public String getCode() {
        System.out.println(getClass()+": getcode()");
        return code;
    }

    public void setCode(String code) {
        System.out.println(getClass()+": setcode()");
        this.code = code;
    }
}
