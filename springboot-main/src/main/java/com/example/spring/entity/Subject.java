package com.example.spring.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 18:31 2021/11/3
 */

@Entity
@Data
@Table(name = "t_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
