package com.jakhongir.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SwimmingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Get daily workout from Swimming coach";
    }
}
