package com.nekochanoide.univerSpringSecurity.controllers;

import com.nekochanoide.univerSpringSecurity.models.Role;
import com.nekochanoide.univerSpringSecurity.models.User;
import com.nekochanoide.univerSpringSecurity.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class IdentitiesController {
    private final UsersService usersService;

    public IdentitiesController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(User user, Model model) {
        if (usersService.saveUser(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("message", "User exists");
            return "register";
        }
    }
}
