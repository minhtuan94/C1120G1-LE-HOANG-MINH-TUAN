package com.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showHome() {
        return "/login/home";
    }

    @GetMapping("/403")
    public String show403() {
        return "/login/403Page";
    }

    @GetMapping("/home_logged")
    public String logged(){
        return "/login/home_logged";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
    }