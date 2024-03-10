package com.jakhongir.springboot.demo.mycoolapp.dao;

import com.jakhongir.springboot.demo.mycoolapp.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class InstructorDAOImple implements InstructorDAO {

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
