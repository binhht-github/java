package com.example.demo2.model;

import javax.persistence.*;
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
@Table(name = "BaoHiemXaHoi")
public class BaoHiemXaHoi {
    @Id
    private String maBHXH;

//    @OneToOne(mappedBy = "bhxh")
    @OneToOne()
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien" )
    private NhanVien nhanVien;

    @Column(name ="ngayThamGia")
    private Date ngayThamGia;

    @Column(name = "mucDong") //1.800.000 vnd
    private int mucDong;

    @Column(name = "tiLeDong") //20%
    private int tiLeDong;

    @Column(name = "hinhThucThamGia")
    private String hinhThucThamGia; //tu nguyen, bat buoc

    @Column(name = "noiThamGia")
    private String noiThamGia; // cty x

    @Column(name = "soBHXH")
    private String xoBHXH; //035126645

    @Column(name = "ngayCap")
    private Date ngayCap;

    @Column(name = "trangThai") // dang dong, ngung dong
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

    //    Cấu trúc:
//
//    Mã BHXH (khóa chính): Mã số duy nhất để nhận diện mỗi người tham gia bảo hiểm xã hội.
//    Mã nhân viên: Mã số liên kết với bảng Nhân viên.
//    Ngày bắt đầu tham gia: Ngày bắt đầu tham gia bảo hiểm xã hội.
//    Mức đóng: Mức đóng bảo hiểm xã hội theo quy định của pháp luật.
//    Tỷ lệ đóng: Tỷ lệ đóng bảo hiểm xã hội theo quy định của pháp luật.
//    Hình thức tham gia: Hình thức tham gia bảo hiểm xã hội (bắt buộc, tự nguyện).
//    Nơi tham gia: Nơi tham gia đóng bảo hiểm xã hội (công ty, tổ chức, cá nhân).
//    Số sổ BHXH: Số sổ bảo hiểm xã hội.
//    Ngày cấp sổ: Ngày cấp sổ bảo hiểm xã hội.
//    Trạng thái: Trạng thái tham gia bảo hiểm xã hội (đang đóng, ngừng đóng, ...).
//    Mối quan hệ:
//
//    Bảng Bảo hiểm xã hội có mối quan hệ một-nhiều với bảng Hồ sơ BHXH.
//    Bảng Bảo hiểm xã hội có mối quan hệ một-nhiều với bảng Lịch sử đóng BHXH.
}



