package com.jakhongir.springboot.demo.mycoolapp;

import com.jakhongir.springboot.demo.mycoolapp.dao.AccountDAO;
import com.jakhongir.springboot.demo.mycoolapp.dao.InstructorDAO;
import com.jakhongir.springboot.demo.mycoolapp.dao.MembershipDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.*;
import com.jakhongir.springboot.demo.mycoolapp.entity.Course;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import com.jakhongir.springboot.demo.mycoolapp.entity.InstructorDetail;
import com.jakhongir.springboot.demo.mycoolapp.entity.Review;
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
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO, AccountDAO accountDAO, MembershipDAO membershipDAO) {
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
//        this.deleteCourseById(instructorDAO);
//        this.createCourse(instructorDAO)
//        this.findCourseAndReviewsByCourseId(instructorDAO);
//        this.createCourseAndStudents(instructorDAO);
//        this.findCourseAndStudents(instructorDAO);
//        this.findCourseAndReviewsByStudentId(instructorDAO);
//        this.addMoreCoursesForStudent(instructorDAO);
//        this.deleteStudentById(instructorDAO);
        return runner -> {
            addAccount(accountDAO);
            membershipDAO.addAccount();
        };
    }

    private void addAccount(AccountDAO accountDAO) {
        Employee employee = new Employee("John","Sam","john@gmail.com","engineer");
        accountDAO.addAccount(employee,true);
    }

    private void deleteStudentById(InstructorDAO instructorDAO) {
        instructorDAO.deleteStudentById(2);
    }

    private void addMoreCoursesForStudent(InstructorDAO instructorDAO) {
        Student student = instructorDAO.findCourseAndStudentsByStudentId(2);

        // create more courses
        Course course = new Course("Software Engineering");
        Course course1 = new Course("Machine learning");

        instructorDAO.save(course);
        instructorDAO.save(course1);

        student.addCourse(course);
        student.addCourse(course1);

        System.out.println("Updating student " + student);
        System.out.println("Associated courses " + student.getCourses());

        instructorDAO.update(student);
    }

    private void findCourseAndReviewsByStudentId(InstructorDAO instructorDAO) {
        Student student = instructorDAO.findCourseAndStudentsByStudentId(2);
        System.out.println("Student " + student);
        System.out.println("Courses " + student.getCourses());
    }

    private void findCourseAndStudents(InstructorDAO instructorDAO) {
        Course course = instructorDAO.findCourseAndStudentsByCourseId(15);
        System.out.println("Course " + course);
        System.out.println("Students " + course.getStudents());
    }

    private void createCourseAndStudents(InstructorDAO instructorDAO) {
        // create course
        Course course = new Course("Math");

        // create and save students
        Student john = new Student("John", "Edison", "john@gmail.com");
        Student mike = new Student("Mike", "Edison", "mike@gmail.com");

        instructorDAO.save(john);
        instructorDAO.save(mike);


        // add students to the course
        course.addStudent(john);
        course.addStudent(mike);

        // save the course and associated students
        instructorDAO.save(course);
    }

    private void findCourseAndReviewsByCourseId(InstructorDAO instructorDAO) {
        Course course = instructorDAO.findCourseAndReviewsByCourseId(1);
        System.out.println("Course " + course);
        System.out.println("Reviews of the Course " + course.getReviews());

    }

    private void createCourse(InstructorDAO instructorDAO) {
        Course course = new Course("test course");
//        Instructor instructor = instructorDAO.findInstructorById(1);
//        course.setInstructor(instructor);
        Review review = new Review("test comment");
        course.addReview(review);
        System.out.println("Get course reviews " + course.getReviews());
        instructorDAO.save(course);
    }

    private void deleteCourseById(InstructorDAO instructorDAO) {
        instructorDAO.deleteCourseById(13);
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
