package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChamCongDTO {

    private String maChamCong;

    private String maNhanVien;

    private Date ngayChamCong;

    private String viTri;

    private String loaiChamCong; // in - out

    private String thietBi;

    @Override
    public String toString() {
        return "ChamCong{" +
                "maChamCong='" + maChamCong + '\'' +
//                ", nhanVien=" + nhanVien +
                ", ngayChamCong=" + ngayChamCong +
                ", viTri='" + viTri + '\'' +
                ", loaiChamCong='" + loaiChamCong + '\'' +
                ", thietBi='" + thietBi + '\'' +
                '}';
    }
}
