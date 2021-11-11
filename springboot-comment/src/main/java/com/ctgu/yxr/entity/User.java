package com.ctgu.yxr.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",unique = true)
    private String username;

    @Column(name = "pwd")
    private String password;

    @Column(name = "icon_url")
    private String url;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
