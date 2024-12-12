package com.hitham.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImpl implements TrafficFortune{

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Except heavy traffic morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire == true) {
            throw new RuntimeException("Accident!");
        }

        return getFortune();
    }
}
