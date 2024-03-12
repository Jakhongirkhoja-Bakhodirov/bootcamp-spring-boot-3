package com.jakhongir.springboot.demo.mycoolapp;

import com.jakhongir.springboot.demo.mycoolapp.dao.InstructorDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Course;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import com.jakhongir.springboot.demo.mycoolapp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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
//        this.deleteInstructorDetail(instructorDAO);
//        this.createInstructorWithCourses(instructorDAO);
//        this.findInstructorWithCourses(instructorDAO);
//        this.findCoursesForInstructor(instructorDAO);
//        this.findCoursesForInstructorJoinFetch(instructorDAO);
//        this.updateInstructor(instructorDAO);
//        this.updateCourse(instructorDAO);
//        this.deleteInstructor(instructorDAO);
        this.deleteCourseById(instructorDAO);
        return runner -> {
        };
    }

    private void deleteCourseById(InstructorDAO instructorDAO) {
        instructorDAO.deleteCourseById(1);
    }

    private void updateCourse(InstructorDAO instructorDAO) {
        Course course = instructorDAO.findCourseById(1);
        course.setTitle("Updated title");
        instructorDAO.update(course);
        System.out.println("Updated Course " + course.toString());
    }

    private void updateInstructor(InstructorDAO instructorDAO) {
        Instructor instructor = instructorDAO.findInstructorById(1);
        instructor.setEmail("update@gmail.com");
        instructorDAO.update(instructor);
        System.out.println("Updated Instructor " + instructor.toString());
    }

    private void findCoursesForInstructorJoinFetch(InstructorDAO instructorDAO) {
        Instructor instructor = instructorDAO.findCoursesByInstructorIdJoinFetch(18);
        System.out.println("Instructor Courses " + instructor.getCourses());
    }

    private void findCoursesForInstructor(InstructorDAO instructorDAO) {
        int id = 18;
        Instructor instructor = instructorDAO.findInstructorById(id);

        List<Course> courses = instructorDAO.findCoursesByInstructorId(id);

        System.out.println("Courses " + courses);
    }

    private void findInstructorWithCourses(InstructorDAO instructorDAO) {
        int id = 18;

        Instructor instructor = instructorDAO.findInstructorById(id);

        System.out.println("Instructor " + instructor.toString());
        System.out.println("The associated courses: " + instructor.getCourses());
    }

    private void createInstructorWithCourses(InstructorDAO instructorDAO) {
        // create Instructor
        Instructor instructor = new Instructor("Test", "test", "test@gmail.com");

        // create Instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("test channel", "test hobby");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        Course firstCourse = new Course("test course");
        Course secondCourse = new Course("test next course");

        List<Course> courses = new ArrayList<>();
        courses.add(firstCourse);
        courses.add(secondCourse);

        instructor.setCourses(courses);

//        instructor.addCourse(firstCourse);
//        instructor.addCourse(secondCourse);

        System.out.println("Saving instructor: " + instructor);

        instructorDAO.save(instructor);
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
        instructorDAO.deleteInstructorById(18);
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
