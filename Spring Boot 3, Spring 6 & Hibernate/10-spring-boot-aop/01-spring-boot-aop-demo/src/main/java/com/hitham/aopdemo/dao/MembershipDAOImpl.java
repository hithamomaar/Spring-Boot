package com.hitham.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addMember() {
        System.out.println(getClass()+": Doing DB WORK: Membership");
        return true;
    }

    @Override
    public void goSleep() {
        System.out.println(getClass()+": going to sleep..");
    }
}
