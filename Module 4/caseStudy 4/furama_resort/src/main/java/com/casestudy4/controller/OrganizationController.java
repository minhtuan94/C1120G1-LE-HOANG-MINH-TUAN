package com.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {
    @GetMapping("/nav/organization")
    public String organization(){
        return "nav/organization";
    }
}
