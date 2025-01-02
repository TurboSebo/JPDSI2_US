package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.UserRepository;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    // Konstruktor wstrzykujący UserService
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("pageTitle", "Rejestracja - Cybercentrum");
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user,
                                      @RequestParam("confirmPassword") String confirmPassword,
                                      @RequestParam(value = "terms", required = false) String termsAccepted,
                                      Model model){
        //czy hasła zgodne?
        if(!user.getPassword().equals(confirmPassword)){
            model.addAttribute("error", "Hasła nie są zgodne!");
            return "registration";
        }
        //czy zaakceptowano regulamin?
        if (termsAccepted == null){
            model.addAttribute("error", "Musisz zaakceptować regulamin");
            return "registration";
        }
        //zajęta nazwa użytkownika
        if(userRepository.existsByUsername(user.getUsername())){
            model.addAttribute("error", "Nazwa użytkownika jest zajęta!");
            return "registration";
        }
        //email zajęty
        if(userRepository.existsByEmail(user.getEmail())){
            model.addAttribute("error", "Adres email jest już zarejestrowany");
            return "registration";
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            userService.registerUser(user);
            return "redirect:/login";
        }
        catch(Exception e){
            // Obsługa błędów
            model.addAttribute("error", "Rejestracja nie powiodła się: " + e.getMessage());
            return "registration"; // Powrót na stronę rejestracji
        }
    }
}
