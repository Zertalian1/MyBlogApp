package com.example.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String home(@RequestParam(value = "name", required = false, defaultValue = "user" ) String name, Model model) {
        model.addAttribute("name", name);
        return "home";
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
