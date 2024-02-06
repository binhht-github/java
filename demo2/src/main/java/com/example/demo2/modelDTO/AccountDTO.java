package com.example.demo2.modelDTO;


import com.example.demo2.model.NhanVien;
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
public class AccountDTO {

    private Long id;

    private NhanVien nhanVien;

    private  String username;

    private String password;

    private String deleted;

    private Date createDate;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
//                ", nhanVien=" + nhanVien +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deleted='" + deleted + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
