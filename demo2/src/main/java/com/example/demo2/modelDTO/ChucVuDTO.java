package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChucVuDTO {

    private String maChucVu;

    private NhanVien nhanVien;

    private String tenChucVu;

    private String moTa;

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
}
