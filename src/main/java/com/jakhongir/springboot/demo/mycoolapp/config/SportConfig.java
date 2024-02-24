package com.jakhongir.springboot.demo.mycoolapp.config;

import com.jakhongir.springboot.demo.mycoolapp.common.Coach;
import com.jakhongir.springboot.demo.mycoolapp.common.SwimmingCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("swimmer")
    public Coach swimCoach() {
        return new SwimmingCoach();
    }
}
