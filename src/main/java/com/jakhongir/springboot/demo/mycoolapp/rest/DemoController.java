package com.jakhongir.springboot.demo.mycoolapp.rest;

import com.career.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
