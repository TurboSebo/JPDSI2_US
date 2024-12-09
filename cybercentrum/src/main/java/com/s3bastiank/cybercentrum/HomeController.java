package com.s3bastiank.cybercentrum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {return "index"; // Nazwa szablonu HTML bez rozszerzenia
    }
    @GetMapping("/login") public String login(Model model) {
        model.addAttribute("pageTitle", "Logowanie - Cybercentrum");
        return "login";
    }
//    @GetMapping("/register") public String register(Model model) {
//        model.addAttribute("pageTitle", "Rejestracja - Cybercentrum");
//        return "registration";
//    }
}
