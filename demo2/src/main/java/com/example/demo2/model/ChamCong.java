package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChamCong")
public class ChamCong {

    @Id
    private String maChamCong;


    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

    @Column(name = "ngayChamCong")
    private Date ngayChamCong;

    @Column(name = "viTri")
    private String viTri;

    @Column(name = "loaiChamCong")
    private String loaiChamCong; // in - out

    @Column(name = "thietBI")
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

    //    Mã chấm công  	Mã nhân viên    	  Ngày giờ      	Vị trí  	Loại chấm công  	Thiết bị
//       CC001	            NV001	        01/03/2024 08:00   Văn phòng	    Vào	              Máy chấm công
//       CC001	            NV001	        01/03/2024 08:00   Văn phòng	    ra	              Máy chấm công
//    CC002	NV002	01/03/2024 08:30	Văn phòng	Vào	Điện thoại
}
