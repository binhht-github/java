package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HopDongLaoDongDTO {

    private String maHopDongLaoDong;

    private NhanVien nhanVien;

    private Date ngayBatDau;

    private Date ngayKetThuc; //

    private String loaiHopDong; // partTime/ chinh thuc, thuc tap

    private String mucLuong;

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
