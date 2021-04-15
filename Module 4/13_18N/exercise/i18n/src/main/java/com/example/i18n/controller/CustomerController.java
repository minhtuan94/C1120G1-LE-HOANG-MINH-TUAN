package com.example.i18n.controller;

import com.example.i18n.model.Customer;
import com.example.i18n.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String showCustomer(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "view";
    }

}