package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final UserService userService;

    @Autowired()
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String table(Model model,@CurrentSecurityContext(expression = "authentication.principal") User principal) {
        model.addAttribute("table", userService.getAllUsers());
        model.addAttribute("user", principal);
        return "table";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userService.addUser(user);
        }
        return "redirect:/admin/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.removeUser(id);
        return "redirect:/admin/";
    }

    @PostMapping("/edit")
    public String update(@RequestParam int id, User user, BindingResult bindingResult) {
        user.setUserId(id);
        if (!bindingResult.hasErrors()) {
            userService.updateUser(user);
        }
        return "redirect:/admin/";
    }
}