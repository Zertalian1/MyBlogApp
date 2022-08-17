package com.example.webapp.controllers;



import com.example.webapp.model.Entry;
import com.example.webapp.service.Impl.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    EntryServiceImpl service;

    @Autowired
    public BlogController(EntryServiceImpl service) {
        this.service = service;
    }

    // все записи
    @GetMapping()
    public String getEntries(Model model){
        model.addAttribute("entries", service.getAllEntries());
        return "blog_main";
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
        return "blog_entry";
    }

    // получение формы на изменение
    @GetMapping("/{entryId}/edit")
    public String getUpdate(Model model, @PathVariable int entryId){
        Entry entry = service.getEntryById(entryId);
        model.addAttribute("entry", entry);
        return "edit_entry";
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
        return "new_entry";
    }
}
