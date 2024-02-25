package com.example.demo2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name = "ChucVu")
public class ChucVu {

    @NotNull
    @Id
    private String maChucVu;

//    @OneToOne(mappedBy = "chucVu")
//    @OneToOne()
    @OneToMany(mappedBy = "chucVu")
//    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien" )
    private List<NhanVien> nhanViens;

    @NotNull
    @Column(name = "tenChucVu")
    private String tenChucVu;

    @Column(name = "moTa")
    private String moTa;

    @NotNull
    @Column(name = "mucluongCoBan")
    private int mucluongCoBan; //

    @NotNull
    @Column(name = "heSoLuong")
    private float heSoLuong; //

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
