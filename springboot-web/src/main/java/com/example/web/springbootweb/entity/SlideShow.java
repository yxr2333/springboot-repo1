package com.example.web.springbootweb.entity;


import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 10:11
 */
@Entity
@Data
@Table(name = "t_slideshow")
public class SlideShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "status")
    private Boolean flag;

}
