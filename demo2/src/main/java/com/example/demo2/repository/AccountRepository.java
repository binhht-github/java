package com.example.demo2.repository;

import com.example.demo2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    public final static String EXISTS_BY_USERNAME = "select * from account where username =  ?1";
    @Query(value = EXISTS_BY_USERNAME,nativeQuery = true)
    Account existsByUsername(String username);

    Optional<Account> findByUsername(String username);

    //    @Override
//    boolean existsById(Long aLong);
}
