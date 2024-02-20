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
public class BaoHiemXaHoiDTO {

    private String maBHXH;

    private NhanVien nhanVien;

    private Date ngayThamGia;

    private int mucDong;

    private int tiLeDong;

    private String hinhThucThamGia; //tu nguyen, bat buoc

    private String noiThamGia; // cty x

    private String xoBHXH; //035126645

    private Date ngayCap;

    private String trangThai;

    @Override
    public String toString() {
        return "BaoHiemXaHoi{" +
                "maBHXH='" + maBHXH + '\'' +
//                ", nhanVien=" + nhanVien +
                ", ngayThamGia=" + ngayThamGia +
                ", mucDong=" + mucDong +
                ", tiLeDong=" + tiLeDong +
                ", hinhThucThamGia='" + hinhThucThamGia + '\'' +
                ", noiThamGia='" + noiThamGia + '\'' +
                ", xoBHXH='" + xoBHXH + '\'' +
                ", ngayCap=" + ngayCap +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
