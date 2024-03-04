package com.jakhongir.springboot.demo.mycoolapp.repositories;

import com.jakhongir.springboot.demo.mycoolapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findById(int id);
}
