package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Course;
import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import com.jakhongir.springboot.demo.mycoolapp.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor instructor);

    void save(Course course);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findCoursesByInstructorIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);
}
