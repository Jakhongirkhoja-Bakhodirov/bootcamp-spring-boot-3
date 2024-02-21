package com.jakhongir.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "get daily workout from tennis coach";
    }
}
