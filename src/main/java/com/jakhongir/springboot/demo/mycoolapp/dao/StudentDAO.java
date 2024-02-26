package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
