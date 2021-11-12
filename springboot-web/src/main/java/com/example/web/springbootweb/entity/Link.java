package com.example.web.springbootweb.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 19:59
**/
@Entity
@Table(name = "t_link")
@Getter
@Setter
@ToString
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "title")
    private String title;

}
