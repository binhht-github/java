package com.example.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class JwtApplication {
  System.out.println(SpringVersion.getVersion());
        System.out.println(SpringBootVersion.getVersion());
    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);

    }

}
