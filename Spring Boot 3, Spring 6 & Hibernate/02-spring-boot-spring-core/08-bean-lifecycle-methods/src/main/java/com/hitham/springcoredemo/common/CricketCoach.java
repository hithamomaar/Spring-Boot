package com.hitham.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("in constructor: " + this.getClass().getSimpleName());
    }

    // init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("in doMyStartupStuff(): " + this.getClass().getSimpleName());
    }

    // destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("in doMyCleanupStuff(): " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
