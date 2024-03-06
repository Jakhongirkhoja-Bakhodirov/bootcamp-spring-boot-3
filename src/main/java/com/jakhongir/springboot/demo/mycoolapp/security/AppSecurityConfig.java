package com.jakhongir.springboot.demo.mycoolapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class AppSecurityConfig {

    // add support for JDBC ... no more hardcode users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,password,active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?    ");

        return jdbcUserDetailsManager;
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails employee = User.builder()
//                .username("employee")
//                .password("{noop}test123").roles("EMPLOYEE").build();
//
//        UserDetails manager = User.builder()
//                .username("test")
//                .password("{noop}test1234").roles("MANAGER","EMPLOYEE").build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}test123").roles("ADMIN","EMPLOYEE","MANAGER").build();
//
//        return new InMemoryUserDetailsManager(employee, manager, admin);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //Use HTTP basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
