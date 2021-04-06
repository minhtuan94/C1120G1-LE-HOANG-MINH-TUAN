package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("customers",customerService.findAllCustomer());
        return "/home";
    }

    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/create/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("edit",customerService.findById(id));
        return "/edit";
    }

    @GetMapping("/customer/delete")
    public String delete(@RequestParam Integer id){
        customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("view",customerService.findById(id));
        return "/view";
    }
}
