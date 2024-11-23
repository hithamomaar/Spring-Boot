package com.hitham.springcoredemo.config;

import com.hitham.springcoredemo.common.Coach;
import com.hitham.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("test")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
