package com.example.demo2.services;

import com.example.demo2.model.*;
import com.example.demo2.model.security.CustomUserDetails;
import com.example.demo2.model.security.JwtUserFactory;
import com.example.demo2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices  implements UserDetailsService {
    @Autowired
    private AccountRepository rs;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong database không?
        Account user = rs.findByUsername(username).get();
//        Account user = rs.findById(Long.parseLong(username)).get();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
//        return new CustomUserDetails(user);
        return JwtUserFactory.create(user);
    }
}
