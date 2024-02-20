package com.example.jwt2.repository;

import com.example.jwt2.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findByUserName(String username);
//    Accounts findByuserName();
}

