package com.jakhongir.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class SwimmingCoach implements Coach {
    public SwimmingCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Get daily workout from Swimming coach";
    }
}
