package com.example.demo2.repository;

import com.example.demo2.model.BaoHiemXaHoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaoHiemXaHoiRepository extends JpaRepository<BaoHiemXaHoi,String> {
}
