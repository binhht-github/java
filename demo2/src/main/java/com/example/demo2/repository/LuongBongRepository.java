package com.example.demo2.repository;

import com.example.demo2.model.LuongBong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuongBongRepository extends JpaRepository<LuongBong,Long> {
}
