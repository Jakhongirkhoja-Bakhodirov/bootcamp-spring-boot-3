package com.jakhongir.springboot.demo.mycoolapp.common;

import com.jakhongir.springboot.demo.mycoolapp.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast run only 10min";
    }
}
