package com.example.jwt.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catego")
public class Categori {
    @Id
    @GeneratedValue
    private Long id;
}
