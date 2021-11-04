package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小喻同学
 */
@Entity
@Table(name = "t_students")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" ,"handler"})
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

    @Column(name = "college")
    private String college;

    @Column(name = "phone")
    private String phone;


    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany()
    private List<SmallClass> classes = new ArrayList<>();
}
