package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 18:30 2021/11/3
 */
@Entity
@Data
@Table(name = "t_class")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" ,"handler"})
public class SmallClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Clerk clerk;
}
