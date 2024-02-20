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
@Table(name = "KyLuat")
public class KyLuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maKyLuat")
    private String maKyLuat;

    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

    @Column(name = "ngayViPham")
    private Date ngayViPham;

    @Column(name = "liDoViPham")
    private String liDoViPham; //

    @Column(name = "hinhThucKyLuat")
    private String hinhThucKyLuat; //

    @Column(name = "mucPhat")
    private float mucPhat;


    @Override
    public String toString() {
        return "KyLuat{" +
                "id=" + id +
                ", maKyLuat='" + maKyLuat + '\'' +
//                ", nhanVien=" + nhanVien +
                ", ngayViPham=" + ngayViPham +
                ", liDoViPham='" + liDoViPham + '\'' +
                ", hinhThucKyLuat='" + hinhThucKyLuat + '\'' +
                ", mucPhat=" + mucPhat +
                '}';
    }
}

