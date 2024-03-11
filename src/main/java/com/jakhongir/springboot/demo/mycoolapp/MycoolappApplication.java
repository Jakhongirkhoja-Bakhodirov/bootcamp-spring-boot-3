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

//        this.createInstructor(instructorDAO);
//        this.findInstructor(instructorDAO);
//        this.deleteInstructor(instructorDAO);
//        this.findInstructorDetail(instructorDAO);
        this.deleteInstructorDetail(instructorDAO);
        return runner -> {
        };
    }

    private void deleteInstructorDetail(InstructorDAO instructorDAO) {
        instructorDAO.deleteInstructorDetailById(6);
    }

    private void findInstructorDetail(InstructorDAO instructorDAO) {
        InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(3);
        System.out.println("Instructor detail: " + instructorDetail.toString());
        System.out.println("Instructor itself: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(InstructorDAO instructorDAO) {
        instructorDAO.deleteInstructorById(2);
    }

    private void findInstructor(InstructorDAO instructorDAO) {
        int id = 2;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = instructorDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor.toString());
        System.out.println("Associated instructor detail: " + instructor.getInstructorDetail());
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
