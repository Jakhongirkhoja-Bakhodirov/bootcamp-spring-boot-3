package com.jakhongir.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "get daily workout from tennis coach";
    }
}
