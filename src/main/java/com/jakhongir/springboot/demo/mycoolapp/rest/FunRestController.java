package com.jakhongir.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @Value("${first.value}")
    private String firstValue;

    //expose "/" endpoint return "Hello World"
    @GetMapping
    public String sayHello() {
        return firstValue;
    }
}
