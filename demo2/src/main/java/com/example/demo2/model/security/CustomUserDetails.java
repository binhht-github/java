package com.example.demo2.model.security;

import com.example.demo2.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
//@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

//    Account acc;
//
//        @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản.
//        return Collections.singleton(new SimpleGrantedAuthority(acc.getNhanVien().getChucVu().getMaChucVu()));
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
//    @Override
//    public String getPassword() {
//        return acc.getPassword();
//
//    }
//
//    @Override
//    public String getUsername() {
//        return acc.getUsername();
//    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
