package com.example.webapp.controllers;

import com.example.webapp.model.User;
import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserServiceImpl userService;

    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        return "pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User newUser) {
        userService.addUser(newUser);
        return "redirect:/";
    }
}
