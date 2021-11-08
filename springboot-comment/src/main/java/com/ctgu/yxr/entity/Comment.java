package com.ctgu.yxr.entity;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "commment_text")
    private String text;

    @OneToOne
    @JoinColumn(name = "lase_comment_id")
    private Comment lastComment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
