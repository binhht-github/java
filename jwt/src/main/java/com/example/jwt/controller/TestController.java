package com.example.jwt.controller;


import com.example.jwt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired(required = false)
    UserRepository rs;

    @GetMapping("/")
    public void a(){
        System.out.println(rs.findAll());
    }
}
