package com.example.spring.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 小喻同学
 */
@Entity
@Data
public class Student {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "number",unique = true)
    private String number;
    @Column(name = "grade")
    private String grade;
    @Column(name = "major")
    private String major;
    @Column(name = "phone")
    private String phone;
}
