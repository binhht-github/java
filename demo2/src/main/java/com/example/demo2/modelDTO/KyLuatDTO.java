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
public class KyLuatDTO {

    private Long id;

    private String maKyLuat;

    private NhanVien nhanVien;

    private Date ngayViPham;

    private String liDoViPham; //

    private String hinhThucKyLuat; //

    private Float mucPhat;


    @Override
    public String toString() {
        return "KyLuat{" +
                "id=" + id +
                ", maKyLuat='" + maKyLuat + '\'' +
//                ", nhanVien=" + nhanVien +
                ", ngayViPham=" + ngayViPham +
                ", liDoViPham='" + liDoViPham + '\'' +
                ", hinhThucKyLuat='" + hinhThucKyLuat + '\'' +
                ", mucPhat=" + mucPhat +
                '}';
    }
}
