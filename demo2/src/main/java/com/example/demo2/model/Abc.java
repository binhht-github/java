package com.example.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "abc")
public class Abc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String Name;
}
