package com.example.demo2.model;
//import jakarta.persistence.*;
import javax.persistence.*;

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

    @Column(name ="hoTen")
    private  String hoTen;

    @Column(name = "CCCD")
    private  String cccd;

    @Column(name ="email")
    private  String email;

    @Column(name = "gioiTinh")
    private  String gioiTinh;

    @Column(name = "anh")
    private String anh;

    @Column(name = "sdt")
    private  String sdt;

    @Column(name = "diaChi")
    private String diaChi;

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

//    @OneToOne()
//    @JoinColumn(name = "id", referencedColumnName = "id" )
    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private Account account;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "maChucVu", referencedColumnName = "maChucVu" )
    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private ChucVu chucVu;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "maHopDongLaoDong", referencedColumnName = "maHopDongLaoDong" )
    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private HopDongLaoDong hopDongLaoDong;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "maBHXH", referencedColumnName = "maBHXH")
    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private BaoHiemXaHoi bhxh;

    @ManyToOne
    @JoinColumn(name = "maPhongBan")
    private PhongBan phongBan;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<LuongBong> luongBongs;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<ChamCong> chamCongs;

    @JsonIgnore
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
