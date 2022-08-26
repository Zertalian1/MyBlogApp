package com.example.webapp.controllers;

import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    private final UserServiceImpl userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "pages/admin";
    }

    @DeleteMapping("/admin")
    public String  deleteUser(@RequestParam(required = false, defaultValue = "" ) int userId,
                              @RequestParam(required = false, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("allUsers", userService.userGtList(userId));
        return "pages/admin";
    }
}
