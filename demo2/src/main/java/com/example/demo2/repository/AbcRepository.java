package com.example.demo2.repository;

import com.example.demo2.model.PhuCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbcRepository extends JpaRepository<PhuCap,Long> {
}
