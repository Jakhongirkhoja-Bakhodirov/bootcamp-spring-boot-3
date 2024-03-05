package com.jakhongir.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "authorities",uniqueConstraints=@UniqueConstraint(columnNames = {"user_id","authority"}))
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "authority")
    private String authority;

}
