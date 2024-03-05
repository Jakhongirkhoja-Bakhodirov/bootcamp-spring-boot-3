package com.jakhongir.springboot.demo.mycoolapp;

import com.jakhongir.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.jakhongir.springboot.demo.mycoolapp.dao.StudentDAO;
import com.jakhongir.springboot.demo.mycoolapp.entity.Employee;
import com.jakhongir.springboot.demo.mycoolapp.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO, EmployeeDAO employeeDAO) {
        return runner -> {
         //   createStudent(studentDAO);
          //  createEmployee(employeeDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };
    }

    private void createEmployee(EmployeeDAO employeeDAO) {
        Employee employee = new Employee("Test", "Test", "testw@gmail.com", "developer");
        employeeDAO.updateOrCreate(employee);
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        studentDAO.deleteAll();
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 2;
        System.out.println("Getting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        // change first name of student
        student.setFirstName("Tom");

        // update the student
        studentDAO.update(student);

        // display the updated student
        System.out.println("Updated student: " + student);
    }
}
