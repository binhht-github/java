package com.example.demo2.model;

import javax.persistence.*;

import com.example.demo2.modelDTO.ChamCongStatisticsDTO;
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
@NamedNativeQuery(name = "ChamCong.getChamCongStatistic",
        query = "CALL getListChamCong(?1)",
        resultSetMapping = "Mapping.PlayerNameDto")
@SqlResultSetMapping(name = "Mapping.PlayerNameDto",
        classes = @ConstructorResult(targetClass = ChamCongStatisticsDTO.class,
                columns = {
                        @ColumnResult(name = " ma_nhan_vien"),
                        @ColumnResult(name = " ho_ten"),
                        @ColumnResult(name = " ma_chuc_vu"),
                        @ColumnResult(name = " ma_phong_ban"),
                        @ColumnResult(name = " ten_phong_ban"),
                        @ColumnResult(name = " truong_phong"),
                        @ColumnResult(name = " thang_luong"),
                        @ColumnResult(name = " ngay_1"),
                        @ColumnResult(name = " ngay_2"),
                        @ColumnResult(name = " ngay_3"),
                        @ColumnResult(name = " ngay_4"),
                        @ColumnResult(name = " ngay_5"),
                        @ColumnResult(name = " ngay_6"),
                        @ColumnResult(name = " ngay_7"),
                        @ColumnResult(name = " ngay_8"),
                        @ColumnResult(name = " ngay_9"),
                        @ColumnResult(name = " ngay_10"),
                        @ColumnResult(name = " ngay_11"),
                        @ColumnResult(name = " ngay_12"),
                        @ColumnResult(name = " ngay_13"),
                        @ColumnResult(name = " ngay_14"),
                        @ColumnResult(name = " ngay_15"),
                        @ColumnResult(name = " ngay_16"),
                        @ColumnResult(name = " ngay_17"),
                        @ColumnResult(name = " ngay_18"),
                        @ColumnResult(name = " ngay_19"),
                        @ColumnResult(name = " ngay_20"),
                        @ColumnResult(name = " ngay_21"),
                        @ColumnResult(name = " ngay_22"),
                        @ColumnResult(name = " ngay_23"),
                        @ColumnResult(name = " ngay_24"),
                        @ColumnResult(name = " ngay_25"),
                        @ColumnResult(name = " ngay_26"),
                        @ColumnResult(name = " ngay_27"),
                        @ColumnResult(name = " ngay_28"),
                        @ColumnResult(name = " ngay_29"),
                        @ColumnResult(name = " ngay_30"),
                        @ColumnResult(name = " ngay_31")
                }
        )
)
public class ChamCong {

    @Id
    private String maChamCong; // Teen thiet bi + ma nhan vien + ngay cham cong 240219


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

    public ChamCong(NhanVien nhanVien, Date ngayChamCong, String viTri, String loaiChamCong, String thietBi) {
        this.nhanVien = nhanVien;
        this.ngayChamCong = ngayChamCong;
        this.viTri = viTri;
        this.loaiChamCong = loaiChamCong;
        this.thietBi = thietBi;
    }

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

//    private Date thangLuong;
//
//    private int luongChinh;
//
//    private int tongNgayCong;
//
//    private int congChuan;
//
//    private int tangCa;
//
//    private int bhbb;
//
//    private int  bhxh;
//
//    private int bhtn;
//
//    private int bhyt;
//
//    private int luongCoBan; // 10.000.000 vnd
//
//    private int soNgayChamCong;
//
//    private float heSoLuong; // 2.1, 2.5, 2.6
//
//    private String phuCap; // 900.000vnd
//
//    private int thueThuNhapCaNhan; // tinh thue dua tren luong thuc linh
//
//    private int luongThucLinh; // bang luong co ban * he so luong + phu cap - thue thu nhap ca nhan - tien phat - luong cua ngay nghi

    //    Mã chấm công  	Mã nhân viên    	  Ngày giờ      	Vị trí  	Loại chấm công  	Thiết bị
//       CC001	            NV001	        01/03/2024 08:00   Văn phòng	    Vào	              Máy chấm công
//       CC001	            NV001	        01/03/2024 08:00   Văn phòng	    ra	              Máy chấm công
//    CC002	NV002	01/03/2024 08:30	Văn phòng	Vào	Điện thoại
}
