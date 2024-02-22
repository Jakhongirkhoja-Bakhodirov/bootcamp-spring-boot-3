package com.jakhongir.springboot.demo.mycoolapp.common;

import com.jakhongir.springboot.demo.mycoolapp.common.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach {
    public FootballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast run only 10min";
    }
}
