package com.example.demo2.repository;

import com.example.demo2.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan,String> {

    List<PhongBan> findByTenPhongBan(String tenPhongBan);
}
