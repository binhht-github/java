package com.example.jwt.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
