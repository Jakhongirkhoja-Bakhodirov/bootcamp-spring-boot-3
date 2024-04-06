package com.jakhongir.springboot.demo.mycoolapp.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService implements TrafficFortuneServiceInterface {
    @Override
    public String getFortune() throws RuntimeException {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning";
    }
}
