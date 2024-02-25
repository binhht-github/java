package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LuongBongDTO {

    private Long id;

//    private NhanVienDTO nhanVien;
    private String maNhanVien;

    private String hoTen;
    private String chucVu;


    private String phongBan;

    private Date thangLuong;
    private int luongChinh;
    private int tongNgayCong;
    private int congChuan;
    private int tangCa;
    private int bhbb;
    private int bhxh;
    private int bhtn;
    private int bhyt;
    private int luongCoBan;
    private int soNgayChamCong;
    private float heSoLuong;
    private String phuCap;
    private int thueThuNhapCaNhan;
    private int luongThucLinh;

    public LuongBongDTO(String maNhanVien, String hoTen, String chucVu, String phongBan, Date thangLuong, int luongChinh, int tongNgayCong, int congChuan, int tangCa, int bhbb, int bhxh, int bhtn, int bhyt, int luongCoBan, int soNgayChamCong, float heSoLuong, String phuCap, int thueThuNhapCaNhan, int luongThucLinh) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.phongBan = phongBan;
        this.thangLuong = thangLuong;
        this.luongChinh = luongChinh;
        this.tongNgayCong = tongNgayCong;
        this.congChuan = congChuan;
        this.tangCa = tangCa;
        this.bhbb = bhbb;
        this.bhxh = bhxh;
        this.bhtn = bhtn;
        this.bhyt = bhyt;
        this.luongCoBan = luongCoBan;
        this.soNgayChamCong = soNgayChamCong;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
        this.thueThuNhapCaNhan = thueThuNhapCaNhan;
        this.luongThucLinh = luongThucLinh;
    }

//    mã nhân viên: lấy từ NhanVien
//    họ tên: lấy từ NhanVien
//    chúc danh: lấy từ NhanVien
//    lương đóng bảo hiểm bắt buộc:
//    ngày công đi làm:  call proceducer ra được ngày công từ ngày bắt đầu - ngày kết thúc
//    ngày công chuẩn:
//    - các khoản thu  nhập
//            lngày công chuẩn:viết hàm tính lương chính
//            phụ cấp: lấy phụ cấp từ api về
//            tăng ca:   viết hàm tính công tăng ca vào chủ nhật
//    - các khoản trừ vào lương:  viết hàm tính khoản trừ
//            bảo hiểm bắt buộc
//            bảo hiểm xã hội: 0.08
//            bảo hiểm y tếv 0.015
//            bảo hiểm thất nghiệp: 0.01
//            thuế thu nhập cá nhân: viết hàm tính thuế
//            Tạm ứng:   thêm cột tạm ứng
//    thực lĩnh: viết hàm thực lĩnh
}
