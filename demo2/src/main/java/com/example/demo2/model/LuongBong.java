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

    @Column(name = "luongCoBan")
    private Float luongCoBan; // 10.000.000 vnd

    @Column(name = "soNgayChamCong")
    private int soNgayChamCong;

    @Column(name = "heSoLuong")
    private Float heSoLuong; // 2.1, 2.5, 2.6

    @Column(name = "phuCap")
    private String phuCap; // 900.000vnd

    @Column(name = "thueThuNhapCaNhan")
    private String thueThuNhapCaNhan; // tinh thue dua tren luong thuc linh

    @Column(name = "luongThucLinh")
    private String luongThucLinh; // bang luong co ban * he so luong + phu cap - thue thu nhap ca nhan - tien phat - luong cua ngay nghi

    @Column(name  = "createDate")
    private  Date creatDate;
}
