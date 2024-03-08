package com.example.demo2.model.security;

import com.example.demo2.model.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {
    public static CustomUserDetails create(Account user) {
        System.out.println("user "+user);
        return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(), createGrantedAuthorities(user.getNhanVien().getChucVu().getMaChucVu()));
//        return null;
    }

    private static List<GrantedAuthority> createGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));
        return authorities;
    }
}
