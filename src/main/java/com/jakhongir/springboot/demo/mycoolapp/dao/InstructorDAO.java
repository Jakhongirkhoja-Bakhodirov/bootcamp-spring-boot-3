package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Course;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import com.jakhongir.springboot.demo.mycoolapp.entity.InstructorDetail;
import com.jakhongir.springboot.demo.mycoolapp.entity.Student;

import java.util.List;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor instructor);

    void save(Course course);
  
    void save(Student student);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findCoursesByInstructorIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    void update(Student student);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void deleteStudentById(int id);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findCourseAndStudentsByStudentId(int id);
  
    Course findCourseById(int id);
}
