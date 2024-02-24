package com.jakhongir.springboot.demo.mycoolapp.rest;

import com.jakhongir.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach, @Qualifier("tennisCoach") Coach theAnotherCoach) {

        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        myAnotherCoach = theAnotherCoach;
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == theAnotherCoach, " + (myCoach == myAnotherCoach);
    }
}
