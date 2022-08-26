package com.example.webapp.controllers;



import com.example.webapp.model.Entry;
import com.example.webapp.model.User;
import com.example.webapp.service.Impl.EntryServiceImpl;
import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/blog")
public class BlogController {
    EntryServiceImpl service;
    UserServiceImpl userService;

    @Autowired
    public BlogController(EntryServiceImpl service, UserServiceImpl userService) {
        this.service = service;
        this.userService = userService;
    }

    // все записи
    @GetMapping()
    public String getEntries(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("entries", service.getAllEntries());
        return "pages/blog_main";
    }


    // создание новой записи
    @PostMapping()
    public String makeCreate(@ModelAttribute("entry")Entry entry){
        System.out.println(entry.getId());
        service.addEntry(entry);
        return "redirect:/blog";
    }

    // конкретная запись
    @GetMapping("/{entryId}")
    public String getEntry(Model model, @PathVariable int entryId){
        Entry entry = service.getEntryById(entryId);
        model.addAttribute("entry", entry);
        return "pages/blog_entry";
    }

    // получение формы на изменение
    @GetMapping("/{entryId}/edit")
    public String getUpdate(Model model, @PathVariable int entryId){
        Entry entry = service.getEntryById(entryId);
        model.addAttribute("entry", entry);
        return "pages/edit_entry";
    }

    // запрос на изменение
    @PatchMapping("/{entryId}")
    public String makeUpdate(@ModelAttribute("entry")Entry entry, @PathVariable int entryId){
        service.updateEntry(entry, entryId);
        return "redirect:/blog/{entryId}";
    }

    // запрос на удаление
    @DeleteMapping("/{entryId}")
    public String makeDelete(@PathVariable int entryId){
        service.deleteEntryById(entryId);
        return "redirect:/blog";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("entry") Entry person){
        return "pages/new_entry";
    }
}