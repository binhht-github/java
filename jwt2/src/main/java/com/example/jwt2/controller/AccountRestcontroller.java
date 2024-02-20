package com.example.jwt2.controller;

import com.example.jwt2.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestcontroller {
    @Autowired
    AccountServices sv;

    @GetMapping("/")
    public void a(){
        sv.get();
    }
}
