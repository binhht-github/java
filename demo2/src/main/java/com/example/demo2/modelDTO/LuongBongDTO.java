package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LuongBongDTO {

    private Long id;

    private NhanVien nhanVien;

    private Date thangLuong;

    private Float luongCoBan; // 10.000.000 vnd

    private int soNgayChamCong;

    private Float heSoLuong; // 2.1, 2.5, 2.6

    private String phuCap; // 900.000vnd

    private String thueThuNhapCaNhan; // tinh thue dua tren luong thuc linh

    private String luongThucLinh; // bang luong co ban * he so luong + phu cap - thue thu nhap ca nhan - tien phat - luong cua ngay nghi
}
