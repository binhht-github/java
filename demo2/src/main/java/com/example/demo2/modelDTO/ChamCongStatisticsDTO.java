package com.example.demo2.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class ChamCongStatisticsDTO {
//    private Long id;

    private String maNhanVien;

    private String hoTen;

    private String chucVu;

    private String phongBan;

    private String truongPhong;

    private Date thangLuong;

    private String ngay1;
    private String ngay2;
    private String ngay3;
    private String ngay4;
    private String ngay5;
    private String ngay6;
    private String ngay7;
    private String ngay8;
    private String ngay9;
    private String ngay10;
    private String ngay11;
    private String ngay12;
    private String ngay13;
    private String ngay14;
    private String ngay15;
    private String ngay16;
    private String ngay17;
    private String ngay18;
    private String ngay19;
    private String ngay20;
    private String ngay21;
    private String ngay22;
    private String ngay23;
    private String ngay24;
    private String ngay25;
    private String ngay26;
    private String ngay27;
    private String ngay28;
    private String ngay29;
    private String ngay30;
    private String ngay31;


    public ChamCongStatisticsDTO(String maNhanVien, String hoTen, String chucVu, String phongBan, String tenPhongBan, String truongPhong, Date thangLuong, String ngay1, String ngay2, String ngay3, String ngay4, String ngay5, String ngay6, String ngay7, String ngay8, String ngay9, String ngay10, String ngay11, String ngay12, String ngay13, String ngay14, String ngay15, String ngay16, String ngay17, String ngay18, String ngay19, String ngay20, String ngay21, String ngay22, String ngay23, String ngay24, String ngay25, String ngay26, String ngay27, String ngay28, String ngay29, String ngay30, String ngay31) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.phongBan = tenPhongBan;
        this.truongPhong = truongPhong;
        this.thangLuong = thangLuong;
        this.ngay1 = ngay1;
        this.ngay2 = ngay2;
        this.ngay3 = ngay3;
        this.ngay4 = ngay4;
        this.ngay5 = ngay5;
        this.ngay6 = ngay6;
        this.ngay7 = ngay7;
        this.ngay8 = ngay8;
        this.ngay9 = ngay9;
        this.ngay10 = ngay10;
        this.ngay11 = ngay11;
        this.ngay12 = ngay12;
        this.ngay13 = ngay13;
        this.ngay14 = ngay14;
        this.ngay15 = ngay15;
        this.ngay16 = ngay16;
        this.ngay17 = ngay17;
        this.ngay18 = ngay18;
        this.ngay19 = ngay19;
        this.ngay20 = ngay20;
        this.ngay21 = ngay21;
        this.ngay22 = ngay22;
        this.ngay23 = ngay23;
        this.ngay24 = ngay24;
        this.ngay25 = ngay25;
        this.ngay26 = ngay26;
        this.ngay27 = ngay27;
        this.ngay28 = ngay28;
        this.ngay29 = ngay29;
        this.ngay30 = ngay30;
        this.ngay31 = ngay31;
    }
}
