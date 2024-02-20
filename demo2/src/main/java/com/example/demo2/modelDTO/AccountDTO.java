package com.example.demo2.modelDTO;


import com.example.demo2.model.NhanVien;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;

//    @NotNull(message = "Không được để trống Nhân Viên")
    private NhanVien nhanVien;

    @NotBlank(message = "Không được để trống UserName")
    private  String username;

    private String deleted;

    private Date createDate;

    public AccountDTO(@NotNull(message = "Không được để trống Nhân Viên") NhanVien nhanVien, @NotBlank(message = "Không được để trống UserName") String username, @NotBlank(message = "Không được để trống PassWord") String password, String deleted, Date createDate) {
        this.nhanVien = nhanVien;
        this.username = username;
        this.deleted = deleted;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
//                ", nhanVien=" + nhanVien +
                ", username='" + username + '\'' +
                ", deleted='" + deleted + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
