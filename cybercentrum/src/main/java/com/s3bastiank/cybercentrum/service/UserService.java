package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Wstrzyknięcie zależności

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; 
    }

    public User registerUser(User user) {
        // Haszowanie hasła
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Ustawienie domyślnych wartości
        user.setRegistrationDate(LocalDateTime.now());
        user.setActiveAccount(true);

        // Zapis użytkownika do bazy danych
        return userRepository.save(user);
    }
}
