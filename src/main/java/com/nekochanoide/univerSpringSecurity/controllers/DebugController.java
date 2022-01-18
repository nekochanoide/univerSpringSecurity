package com.nekochanoide.univerSpringSecurity.controllers;

import com.nekochanoide.univerSpringSecurity.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DebugController {
    private final UsersService usersService;

    public DebugController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/debug")
    public String userList(Model model) {
        model.addAttribute("allUsers", usersService.getAllUsers());
        return "admin";
    }

    @PostMapping("/debug")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            usersService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
