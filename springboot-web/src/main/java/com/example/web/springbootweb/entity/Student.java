package com.example.web.springbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:10 2021/11/5
 */
@Entity
@Data
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number",unique = true)
    private String number;

    @Column(name = "grade")
    private String grade;

    @Column(name = "college")
    private String college;

    @Column(name = "major")
    private String major;

    @Column(name = "phone")
    private String phone;

    @Column(name = "qq")
    private String qq;

    @ManyToMany
    @JoinTable(name = "t_students_subjects")
    private List<Subject> subjects;

}
