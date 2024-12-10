package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Ustawienie domyślnych wartości, jeśli są wymagane
        user.setRegistrationDate(LocalDateTime.now());
        user.setActiveAccount(true);

        // Zapis użytkownika do bazy danych
        return userRepository.save(user);
    }
}