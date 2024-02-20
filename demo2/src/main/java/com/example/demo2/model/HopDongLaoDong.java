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
@Table(name = "HopDongLaoDong")
public class HopDongLaoDong {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "maHopDongLaoDong")
    @Id
    private String maHopDongLaoDong;

//    @OneToOne(mappedBy = "hopDongLaoDong")
    @OneToOne()
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien" )
    private NhanVien nhanVien;

    @Column(name = "ngayBatDau")
    private Date ngayBatDau;

    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc; //

    @Column(name = "loaiHopDong")
    private String loaiHopDong; // partTime/ chinh thuc, thuc tap

    @Column(name = "mucLuong")
    private String mucLuong;

    @Column(name = "phuCap")
    private String phuCap;

    @Column(name = "dieuKhoan")
    private String mucluongCoBan; //

    @Override
    public String toString() {
        return "HopDongLaoDong{" +
                "maHopDongLaoDong='" + maHopDongLaoDong + '\'' +
//                ", nhanVien=" + nhanVien +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", loaiHopDong='" + loaiHopDong + '\'' +
                ", mucLuong='" + mucLuong + '\'' +
                ", phuCap='" + phuCap + '\'' +
                ", mucluongCoBan='" + mucluongCoBan + '\'' +
                '}';
    }
}
