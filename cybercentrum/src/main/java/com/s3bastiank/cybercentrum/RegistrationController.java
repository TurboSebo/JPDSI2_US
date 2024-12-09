package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("pageTitle", "Rejestracja - Cybercentrum");
        model.addAttribute("user", new User());
        return "registration";
    }
}
