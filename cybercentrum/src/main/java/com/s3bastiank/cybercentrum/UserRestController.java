package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String query) {
        return userService.searchUsersByUsername(query);
    }
}
