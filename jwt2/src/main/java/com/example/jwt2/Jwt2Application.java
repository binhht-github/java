package com.example.jwt2;

import com.example.jwt2.model.Accounts;
import com.example.jwt2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Jwt2Application implements CommandLineRunner {
    @Autowired
    AccountRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Jwt2Application.class, args);
        System.out.println("spring version "+ SpringVersion.getVersion());
        System.out.println("Spring boot "+SpringBootVersion.getVersion());
        System.out.println("JDK versin "+System.getProperty("java.version"));
        System.out.println("java version "+ JavaVersion.getJavaVersion().toString());
    }
    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        Accounts user = new Accounts();
        user.setUserName("loda");
        user.setPassWord(passwordEncoder.encode("loda"));
//        userRepository.save(user);
        System.out.println(user);
    }

}
