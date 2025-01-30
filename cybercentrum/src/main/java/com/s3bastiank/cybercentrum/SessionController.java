package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.UserRepository;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SessionController {

    private final UserService userService;
    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard") public String login(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("pageTitle", "Dashboard - Cybercentrum");
        model.addAttribute("username", username);
        // Pobieranie informacji o zalogowanym użytkowniku
        User currentUser = userService.getUserByUsername(username);
        String currentRole = currentUser.getRoleName();
        model.addAttribute("currentRole", currentRole);
        return "dashboard";
    }
    @GetMapping("/profile")
    public String redirectToProfile(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        return "redirect:/user/" + username;
    }

}
