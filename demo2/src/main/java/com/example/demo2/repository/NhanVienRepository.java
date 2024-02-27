package com.example.demo2.repository;

import com.example.demo2.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    public final static String GET_LOAN_REPORTS = "SELECT if(max(SUBSTRING( ma_nhan_vien, -4, 4 )) is null,'0001',max(SUBSTRING( ma_nhan_vien, -4, 4 ))) AS numbers FROM nhan_vien where SUBSTRING_INDEX(ma_nhan_vien, '0', 1) = ?1";
    @Query(value=GET_LOAN_REPORTS,nativeQuery = true)
    Integer  getMaNhanVien(String maPhongBan);
}
