package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChucVu")
public class ChucVu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "maChucVu")
    @Id
    private String maChucVu;

//    @OneToOne(mappedBy = "chucVu")
    @OneToOne()
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien" )
    private NhanVien nhanVien;

    @Column(name = "tenChucVu")
    private String tenChucVu;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "mucluongCoBan")
    private String mucluongCoBan; //

    @Override
    public String toString() {
        return "ChucVu{" +
                "maChucVu='" + maChucVu + '\'' +
//                ", nhanVien=" + nhanVien +
                ", tenChucVu='" + tenChucVu + '\'' +
                ", moTa='" + moTa + '\'' +
                ", mucluongCoBan='" + mucluongCoBan + '\'' +
                '}';
    }

    //    @Column(name = "rankLuong")
//    private String rankLuong; // luong cho tung vi
}
