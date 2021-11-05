package com.example.web.springbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:25 2021/11/4
 */
@Data
@Entity
@Table(name = "t_teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
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

    @Column(name = "qq")
    private String qq;

    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(name = "t_teachers_subjects")
    private List<Subject> subjects;
}
