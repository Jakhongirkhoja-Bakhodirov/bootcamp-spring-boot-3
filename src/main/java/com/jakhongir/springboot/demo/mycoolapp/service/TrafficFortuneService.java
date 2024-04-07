package com.jakhongir.springboot.demo.mycoolapp.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService implements TrafficFortuneServiceInterface {
    @Override
    public String getFortune() throws RuntimeException {
        try {
            System.out.println("Expected!");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tip) throws Exception {
        try {
            if (tip) {
                throw new Exception("Some went wrong");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return "Expect heavy traffic this morning";
    }
}
