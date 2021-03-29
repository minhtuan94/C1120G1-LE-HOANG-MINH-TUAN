package com.money.controller;

import com.money.service.MoneyService;
import com.money.service.impl.MoneyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {

    //đánh dấu để chương trình tiêm sự phụ thuộc vào đây
    @Autowired
    private MoneyService moneyService;

    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @PostMapping("/money")
    public String money(@RequestParam double num1, @RequestParam double num2, Model model){
        double result = moneyService.money(num1,num2);
        model.addAttribute("result",result);
        return "/result";
    }
}
