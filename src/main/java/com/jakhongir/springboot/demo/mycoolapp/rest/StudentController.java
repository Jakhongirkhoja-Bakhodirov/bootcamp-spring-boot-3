package com.jakhongir.springboot.demo.mycoolapp.rest;

import com.jakhongir.springboot.demo.mycoolapp.dao.StudentDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentDAO.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return student;
    }
}
