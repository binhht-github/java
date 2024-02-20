package com.example.demo2.repository;

import com.example.demo2.model.KyLuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyLuatRepository extends JpaRepository<KyLuat,Long> {


}
