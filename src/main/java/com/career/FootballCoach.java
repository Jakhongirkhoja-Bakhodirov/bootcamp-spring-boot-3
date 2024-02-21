package com.career;

import com.career.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast run only 10min";
    }
}
