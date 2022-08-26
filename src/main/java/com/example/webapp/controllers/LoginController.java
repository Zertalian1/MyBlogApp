package com.example.webapp.controllers;

import com.example.webapp.model.User;
import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    UserServiceImpl userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String getSign_inPage(@ModelAttribute("user") User user){
        return "/pages/sign-in";
    }

    @PostMapping("/sign-in")
    public String sign_in(@ModelAttribute("user") User user){
        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        return "redirect:/";
    }
}
