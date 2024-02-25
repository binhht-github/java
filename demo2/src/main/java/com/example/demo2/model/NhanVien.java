package com.example.demo2.model;
//import jakarta.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name ="employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "loai_nhanVien")
public class NhanVien {

    @Id
    private String maNhanVien;

    @NotBlank(message = "Không được để trống họ tên")
    @Column(name ="hoTen")
    private  String hoTen;

    @NotBlank(message = "Không được để trống CCCD")
    @Column(name = "CCCD")
    private  String cccd;

    @NotBlank(message = "Không được để trống Email")
    @Column(name ="email")
    private  String email;

    @NotBlank(message = "Không được để trống Giới tính")
    @Column(name = "gioiTinh")
    private  String gioiTinh;

    @Column(name = "anh")
    private String anh;

    @NotBlank(message = "Không được để trống SĐT")
    @Column(name = "sdt")
    private  String sdt;

    @NotBlank(message = "Không được để trống Địa Chỉ")
    @Column(name = "diaChi")
    private String diaChi;

    @NotNull(message = "Không được để trống Ngày Sinh")
    @Column(name ="ngaySinh")
    private Date ngaySinh;

    @Column (name = "cv")
    private String cv;

    @Column(name = "luongCoBan")
    private int luongCoBan;

    @Column(name = "heSoLuong")
    private float heSoLuong;

    @Column(name = "deleted")
    private String deleted;

    @Column(name = "createDate")
    private  Date createDate;

    @Column(name = "creator")
    private String creator;

    @OneToOne(mappedBy = "nhanVien")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "maChucVu")
    @NotNull(message = "Không được để trống Chúc Vự")
    private ChucVu chucVu;

    @OneToOne(mappedBy = "nhanVien")
    private HopDongLaoDong hopDongLaoDong;

    @OneToOne(mappedBy = "nhanVien")
    private BaoHiemXaHoi bhxh;

    @NotNull(message = "Không được để trống Phòng Ban")
    @ManyToOne
    @JoinColumn(name = "maPhongBan")
    private PhongBan phongBan;

    @OneToMany(mappedBy = "nhanVien")
    private List<LuongBong> luongBongs;

//    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<ChamCong> chamCongs;

//    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<KyLuat> kyLuats;


    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", cccd='" + cccd + '\'' +
                ", email='" + email + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", anh='" + anh + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", cv='" + cv + '\'' +
                ", luongCoBan=" + luongCoBan +
                ", heSoLuong=" + heSoLuong +
                ", deleted='" + deleted + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
