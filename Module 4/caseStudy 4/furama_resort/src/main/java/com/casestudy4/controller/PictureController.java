package com.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PictureController {
    @GetMapping("/nav/picture")
    public String picture(){
        return "nav/picture";
    }
}

