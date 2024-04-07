package com.jakhongir.springboot.demo.mycoolapp.service;

public interface TrafficFortuneServiceInterface {
    String getFortune() throws RuntimeException;
    String getFortune(boolean tip) throws Exception;
}
