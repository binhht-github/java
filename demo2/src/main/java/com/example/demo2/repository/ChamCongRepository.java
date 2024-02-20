package com.example.demo2.repository;

import com.example.demo2.model.ChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong,String> {
}
