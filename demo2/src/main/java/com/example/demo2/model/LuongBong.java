package com.example.demo2.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LuongBong")
public class LuongBong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;


    @Column(name = "thangLuong")
    private Date thangLuong;

    @Column(name = "luongChinh")
    private int luongChinh;

    @Column(name = "tongNgayCong")
    private int tongNgayCong;

    @Column(name = "congChuan")
    private int congChuan;

    @Column(name = "tangCa")
    private int tangCa;

    @Column(name = "bhbb")
    private int bhbb;

    @Column(name = "bhxh")
    private int  bhxh;

    @Column(name = "bhtn")
    private int bhtn;

    @Column(name = "bhyt")
    private int bhyt;

    @Column(name = "luongCoBan")
    private int luongCoBan; // 10.000.000 vnd


    @Column(name = "heSoLuong")
    private float heSoLuong; // 2.1, 2.5, 2.6

    @Column(name = "phuCap")
    private String phuCap; // 900.000vnd

    @Column(name = "thueThuNhapCaNhan")
    private int thueThuNhapCaNhan; // tinh thue dua tren luong thuc linh

    @Column(name = "luongThucLinh")
    private int luongThucLinh; // bang luong co ban * he so luong + phu cap - thue thu nhap ca nhan - tien phat - luong cua ngay nghi

    @Column(name  = "creatDate")
    private  Date creatDate;
}
