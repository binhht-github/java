package com.example.demo2.modelDTO;

import com.example.demo2.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NhanVienDTO {

    private String maNhanVien;

    private  String hoTen;

    private  String cccd;

    private  String email;

    private  String gioiTinh;

    private String anh;

    private  String sdt;

    private String diaChi;

    private Date ngaySinh;

    private String cv;

    private int luongCoBan;

    private float heSoLuong;

    private String deleted;

    private  Date createDate;

    private String creator;


}
