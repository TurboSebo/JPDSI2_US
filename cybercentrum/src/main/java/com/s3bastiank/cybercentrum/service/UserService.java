package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.RoleAssignment;
import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.RoleAssignmentRepository;
import com.s3bastiank.cybercentrum.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Wstrzyknięcie zależności
    private final RoleAssignmentRepository roleAssignmentRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleAssignmentRepository roleAssignmentRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleAssignmentRepository = roleAssignmentRepository;
    }

    public User registerUser(User user) {
        // Haszowanie hasła
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Ustawienie domyślnych wartości
        user.setRegistrationDate(LocalDateTime.now());
        user.setActiveAccount(true);

        //Zapis użytkownika
        User savedUser = userRepository.save(user);

        //Przypisanie roli
        RoleAssignment roleAssignment = new RoleAssignment();
        roleAssignment.setUserId(savedUser.getId());
        roleAssignment.setRoleId(3);
        roleAssignment.setGrantedAt(LocalDateTime.now());
        roleAssignment.setWhoGranted(savedUser.getId());
        roleAssignmentRepository.save(roleAssignment);
        // Zapis użytkownika do bazy danych
        savedUser.setRegisteredBy(savedUser.getId());
        return userRepository.save(savedUser);
    }
}
