package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    private String maPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<NhanVien> nhanVien;

    @Column(name = "tenPhongBan")
    private String tenPhongBan;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "truongPhong")
    private String truongPhong; // lk voi  nhan vien ( ma nhan vien )


}
