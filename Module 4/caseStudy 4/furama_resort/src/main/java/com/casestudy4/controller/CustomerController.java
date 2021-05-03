package com.casestudy4.controller;

import com.casestudy4.entity.Customer;
import com.casestudy4.entity.CustomerType;
import com.casestudy4.services.CustomerServices;
import com.casestudy4.services.CustomerTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private CustomerTypeServices customerTypeServices;

    @ModelAttribute("customerType")
    public List<CustomerType> customerTypeList(){
        return customerTypeServices.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model,@PageableDefault(value = 3) Pageable pageable){
        model.addAttribute("customerList",customerServices.sort(pageable));
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/customer/create";
        } else {
            customerServices.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer",customerServices.findById(id));
        return "/customer/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        customerServices.delete(id);
        return "redirect:/customer/list";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("customerView",customerServices.findById(id));
        return "/customer/view";
    }

    @GetMapping("/search")
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, Pageable pageable) {
        if (!keyword.isPresent()) {
            model.addAttribute("customerList", customerServices.findAll(pageable));
            return "customer/list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("customerList", customerServices.search(keywordOld, pageable));
            return "customer/list";
        }
    }

}
