package com.example.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "PhuCap")
public class PhuCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "tenPhuCap")
    private String tenPhuCap;

    @Column(name = "soTien")
    private String soTien;
}
