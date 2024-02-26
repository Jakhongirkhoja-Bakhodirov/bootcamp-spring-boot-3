package com.jakhongir.springboot.demo.mycoolapp;

import com.jakhongir.springboot.demo.mycoolapp.dao.StudentDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Student;
import com.jakhongir.springboot.demo.mycoolapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
          //  createStudent(studentDAO);
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("John", "Doe", "doe@gmail.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student.Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(1);

        // display student
        System.out.println("Found the student: " + myStudent.toString());
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Abror", "Jo'rayev", "abror@gmail.com");
        //save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
