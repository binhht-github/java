package com.example.demo2.modelDTO;

import com.example.demo2.model.NhanVien;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhongBanDTO {

    @NotBlank(message = "Không được để trống mã phòng ban")
    private String maPhongBan;

    private List<NhanVienDTO> nhanVien;

    @NotBlank(message = "Không được để trống tên phòng ban")
    private String tenPhongBan;

    private String moTa;

    private String truongPhong; // lk voi  nhan vien ( ma nhan vien )

    public PhongBanDTO(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }
}
