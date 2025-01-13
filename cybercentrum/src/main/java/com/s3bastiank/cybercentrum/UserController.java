package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{username}")
    public String showUser(@PathVariable String username, Model model, Principal principal) {
        User user = userService.getUserByUsername(username);
        boolean isOwner = principal != null && principal.getName().equals(user.getUsername()); //sprawdza, czy jest to aktywnie zalogowany użytkownik

        model.addAttribute("user", user);
        model.addAttribute("isOwner", isOwner);

        return "userProfile";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("model") User updatedUser, Principal principal) {
        if (principal != null && principal.getName().equals(updatedUser.getUsername())) {
            userService.updateUserProfile(updatedUser);
        }
        return "redirect:/user/" + updatedUser.getUsername();
    }

}
