package com.example.demo2.model;


//import com.example.demo2.modelDTO.AccountDTO;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "account")

//    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien" )
    private NhanVien nhanVien;

    @Column(name ="username")
    private  String username;

    @Column(name = "password")
    private String password;

    @Column(name = "deleted")
    private String deleted;

    @Column(name = "createDate")
    private Date createDate;

    public Account(NhanVien nhanVien, String username, String deleted, Date createDate) {
        this.nhanVien = nhanVien;
        this.username = username;
        this.deleted = deleted;
        this.createDate = createDate;
    }

    public Account(NhanVien nhanVien, String username, String password, String deleted, Date createDate) {
        this.nhanVien = nhanVien;
        this.username = username;
        this.password = password;
        this.deleted = deleted;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
//                ", nhanVien=" + nhanVien +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deleted='" + deleted + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}
