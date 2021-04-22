package com.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroduceController {

    @GetMapping("/nav/introduce")
    public String introduce(){
        return "nav/introduce";
    }
}
