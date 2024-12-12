package com.hitham.aopdemo.dao;

import com.hitham.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account,boolean flag);

    boolean doWork();
}
