package com.s3bastiank.cybercentrum.repository;

import com.s3bastiank.cybercentrum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username); // Metoda do wyszukiwania użytkownika po nazwie
}