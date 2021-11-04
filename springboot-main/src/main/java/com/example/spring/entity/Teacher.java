package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 10:05 2021/11/3
 */
@Entity
@Table(name = "t_teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number",unique = true)
    private String number;

    @Column(name = "grade")
    private String grade;

    @Column(name = "major")
    private String major;

    @Column(name = "college")
    private String college;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Student> students = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SmallClass> classes = new ArrayList<>();

}
