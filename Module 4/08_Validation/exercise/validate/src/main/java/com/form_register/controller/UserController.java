package com.form_register.controller;

import com.form_register.model.User;
import com.form_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
//        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }
}
