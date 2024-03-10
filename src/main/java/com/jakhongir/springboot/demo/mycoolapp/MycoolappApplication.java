package com.jakhongir.springboot.demo.mycoolapp;

import com.jakhongir.springboot.demo.mycoolapp.dao.InstructorDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import com.jakhongir.springboot.demo.mycoolapp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {

        this.createInstructor(instructorDAO);

        return runner -> {
        };
    }

    private void createInstructor(InstructorDAO instructorDAO) {
        // create Instructor
        Instructor instructor = new Instructor("Test", "test", "test@gmail.com");

        // create Instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("test channel", "test hobby");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);

        instructorDAO.save(instructor);
    }
}
