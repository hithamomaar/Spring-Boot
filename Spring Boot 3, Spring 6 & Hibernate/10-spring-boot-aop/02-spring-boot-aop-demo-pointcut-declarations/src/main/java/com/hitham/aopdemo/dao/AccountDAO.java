package com.hitham.aopdemo.dao;

import com.hitham.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    List<Account> findAccounts(boolean b);
    void addAccount(Account account, boolean flag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getCode();

    public void setCode(String code);

}