package com.example.jwt2.services;

import com.example.jwt2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {
    @Autowired
    AccountRepository rs;

    public void get(){
        System.out.println("tang services");
        System.out.println(rs.findAll());
    }

}
