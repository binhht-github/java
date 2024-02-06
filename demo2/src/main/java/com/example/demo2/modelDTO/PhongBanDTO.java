package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhongBanDTO {

    private String maPhongBan;

    private List<NhanVien> nhanVien;

    private String tenPhongBan;

    private String moTa;

    private String truongPhong; // lk voi  nhan vien ( ma nhan vien )
}
