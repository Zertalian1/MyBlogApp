package com.example.webapp.controllers;

import com.example.webapp.model.User;
import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.Soundbank;
import java.security.Principal;


@Controller
public class MainPageController {
    UserServiceImpl userService;

    public MainPageController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        if(principal!=null) {
            User user = userService.findByUsername(principal.getName());
            System.out.println(((Authentication)principal).getAuthorities());
            model.addAttribute("user", user);
        }
        return "pages/home";
    }

    @GetMapping("/user")
    public String userHomePage(){
        System.out.println("Hi");
        return "redirect:/blog";
    }

    @GetMapping("/Calculate")
    public String home(@RequestParam(value = "a", required = false, defaultValue = "0" ) int firstValue,
                       @RequestParam(value = "b", required = false, defaultValue = "0" ) int secondValue,
                       @RequestParam(value = "action", required = false, defaultValue = "sum" ) String action,
                       Model model) {
        System.out.println(action);
        double value=0;
        switch (action){
            case "sum" -> value = firstValue+secondValue;
            case "div" -> value = firstValue/(double)secondValue;
            case "mul" -> value = firstValue*secondValue;
            case "sub" -> value = firstValue-secondValue;
        }

        model.addAttribute("value", value);
        return "calculate";
    }




}
