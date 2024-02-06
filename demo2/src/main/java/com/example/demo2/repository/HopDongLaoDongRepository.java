package com.example.demo2.repository;

import com.example.demo2.model.HopDongLaoDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HopDongLaoDongRepository extends JpaRepository<HopDongLaoDong,String> {
}
