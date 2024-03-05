package com.jakhongir.springboot.demo.mycoolapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails employee = User.builder()
                .username("employee")
                .password("{noop}test123").roles("EMPLOYEE").build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}test123").roles("MANAGER").build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}test123").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(employee, manager, admin);
    }

    ;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
        );
        //Use HTTP basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
