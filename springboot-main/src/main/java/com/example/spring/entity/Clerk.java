package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 18:31 2021/11/3
 */
@Entity
@Data
@Table(name = "t_clerk")
public class Clerk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number",nullable = false)
    private String number;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SmallClass> smallClasses = new ArrayList<>();
}
