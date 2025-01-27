package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
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
        // Pobieranie informacji o zalogowanym użytkowniku
        String PrincipalUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUsername(PrincipalUsername);
        String currentRole = currentUser.getRoleName();

        User user = userService.getUserByUsername(username);
        boolean isOwner = principal != null && principal.getName().equals(user.getUsername()); //sprawdza, czy jest to aktywnie zalogowany użytkownik

        model.addAttribute("user", user);
        model.addAttribute("isOwner", isOwner);
        model.addAttribute("username", username);
        model.addAttribute("currentRole", currentRole);
        return "userProfile";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("model") User updatedUser, Principal principal) {
        if (principal != null && principal.getName().equals(updatedUser.getUsername())) {
            userService.updateUserProfile(updatedUser);
        }
        return "redirect:/user/" + updatedUser.getUsername();
    }
    @PostMapping("/{username}/deactivate")
    public String deactivateUser(@PathVariable String username, Principal principal, Model model) {
        // Zalogowany użytkownik
        User loggedInUser = userService.getUserByUsername(principal.getName());
        // Użytkownik do dezaktywacji
        User userToDeactivate = userService.getUserByUsername(username);

        if (userToDeactivate == null || loggedInUser == null) {
            return "error-404-user"; // Użytkownik nie istnieje
        }
        if (userToDeactivate == loggedInUser) {
            model.addAttribute("error", "Nie możesz zdezaktywować sam siebie");
            return "error-403";
        }

        if ("ADMIN".equals(loggedInUser.getRoleName()) ||
                ("MODERATOR".equals(loggedInUser.getRoleName()) && "USER".equals(userToDeactivate.getRoleName()))) {
            userService.deactivateUser(userToDeactivate);
            model.addAttribute("message", "Użytkownik został pomyślnie dezaktywowany.");
            return "redirect:/user/" + username;
        }

        // Brak uprawnień do dezaktywacji
        return "error-403";
    }
    @PostMapping("/{username}/activate")
    public String activateUser(@PathVariable String username, Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());
        User targetUser = userService.getUserByUsername(username);

        // Administrator może aktywować każde konto
        if (currentUser.getRoleName().equals("ADMIN")) {
            userService.activateUser(targetUser);
        }
        // Moderator może aktywować tylko konta zwykłych użytkowników
        else if (currentUser.getRoleName().equals("MODERATOR") && targetUser.getRoleName().equals("USER")) {
            userService.activateUser(targetUser);
        }

        return "redirect:/user/" + username;
    }

    @PostMapping("/{username}/toggleModerator")
    public String toggleModeratorRole(@PathVariable String username, Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());
        User targetUser = userService.getUserByUsername(username);

        // Sprawdzamy, czy aktualny użytkownik jest administratorem
        if (currentUser.getRoleName().equals("ADMIN")) {
            // Jeśli użytkownik jest moderatorem, odebranie roli
            if (targetUser.getRoleName().equals("MODERATOR")) {
                userService.revokeModeratorRole(targetUser, currentUser);
            }
            // Jeśli użytkownik jest zwykłym użytkownikiem, nadanie roli moderatora
            else if (targetUser.getRoleName().equals("USER")) {
                userService.assignModeratorRole(targetUser, currentUser);
            }
        }

        return "redirect:/user/" + username;
    }



}
