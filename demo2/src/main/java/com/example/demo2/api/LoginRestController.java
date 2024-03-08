package com.example.demo2.api;


import com.example.demo2.fillter.JwtTokenProvider;
import com.example.demo2.model.Account;
import com.example.demo2.model.security.CustomUserDetails;
import com.example.demo2.model.Login;
import com.example.demo2.model.NhanVien;
import com.example.demo2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
    @Autowired
    AccountRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;



    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/register")
    public String register (@RequestBody Login item){
        Account user = new Account();
        user.setUsername(item.getUsername());
        user.setPassword(passwordEncoder.encode(item.getPassword()));
        user.setNhanVien(new NhanVien("DEVB0012"));
        userRepository.save(user);
        System.out.println(user);
        return "registered";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody Login item){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        item.getUsername(),item.getPassword()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        System.out.println(jwt);

        return new ResponseEntity<>(jwt,HttpStatus.OK);
    }
}
