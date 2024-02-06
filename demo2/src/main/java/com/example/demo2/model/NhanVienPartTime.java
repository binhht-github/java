package com.example.demo2.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DiscriminatorValue("employee")
public class NhanVienPartTime extends NhanVien{

    public NhanVienPartTime(Float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

//    public NhanVienPartTime(String maNhanVien, String hoTen, String cccd, String email, String gioiTinh, String anh, String sdt, String diaChi, Date ngaySinh, String cv, Double heSoLuong, String deleted, Date createDate, Account account, ChucVu chucVu, HopDongLaoDong hopDongLaoDong, BaoHiemXaHoi bhxh, PhongBan phongBan, List<LuongBong> luongBongs, List<ChamCong> chamCongs, List<KyLuat> kyLuats, Float hourlyWage) {
//        super(maNhanVien, hoTen, cccd, email, gioiTinh, anh, sdt, diaChi, ngaySinh, cv, heSoLuong, deleted, createDate, account, chucVu, hopDongLaoDong, bhxh, phongBan, luongBongs, chamCongs, kyLuats);
//        this.hourlyWage = hourlyWage;
//    }

    @Column(name = "hourlyWage")
    private Float hourlyWage;

}
