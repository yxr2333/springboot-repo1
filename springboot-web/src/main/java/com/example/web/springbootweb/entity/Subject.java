package com.example.web.springbootweb.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 9:21 2021/11/5
 */
@Entity
@Data
@Table(name = "t_subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

}
