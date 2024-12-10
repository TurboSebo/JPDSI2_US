package com.s3bastiank.cybercentrum.repository;

import com.s3bastiank.cybercentrum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}