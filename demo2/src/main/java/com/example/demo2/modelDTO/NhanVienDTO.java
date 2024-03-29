package com.example.demo2.modelDTO;


import com.example.demo2.model.PhongBan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
//import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NhanVienDTO {

    private String maNhanVien;

    @NotBlank(message = "Không được để trống Họ Tên")
    private  String hoTen;

    @NotBlank(message = "Không được để trống CCCD")
    private  String cccd;

    @NotBlank(message = "Không được để trống Email")
    private  String email;

    @NotBlank(message = "Không được để trống Giới Tính")
    private  String gioiTinh;

    private String anh;

    @NotBlank(message = "Không được để trống Số Điện Thoại")
    private  String sdt;

    @NotBlank(message = "Không được để trống Địa Chỉ")
    private String diaChi;

//    @JsonIgnore
    @JsonProperty("phongban")
    @NotNull(message = "Không được để trống Phòng Ban")
    private String tenPhongBan;

    @JsonProperty("chucvu")
    @NotNull(message = "Không được để trống Chuc vu")
    private String tenChucVu;

    @NotBlank(message = "Không được để trống Ngày Sinh")
    private LocalDate ngaySinh;

//    @Value("true")
//    private Boolean taoTaiKhoan;

    private String cv;

    private int luongCoBan;

    private float heSoLuong;

    private String deleted;

    @Value("${new Date()}")
    private  LocalDate createDate;

    private String creator;


}
