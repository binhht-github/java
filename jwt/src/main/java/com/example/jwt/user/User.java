package com.example.jwt.user;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data // lombok
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}

