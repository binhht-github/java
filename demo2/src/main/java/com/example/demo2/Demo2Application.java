package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
        System.out.println("spring version "+ SpringVersion.getVersion());
        System.out.println("Spring boot "+SpringBootVersion.getVersion());
        System.out.println("JDK versin "+System.getProperty("java.version"));
        System.out.println("java version "+ JavaVersion.getJavaVersion().toString());
    }

}
