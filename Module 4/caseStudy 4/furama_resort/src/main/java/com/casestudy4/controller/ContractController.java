package com.casestudy4.controller;

import com.casestudy4.entity.Contract;
import com.casestudy4.entity.Customer;
import com.casestudy4.entity.Employee;
import com.casestudy4.entity.Service;
import com.casestudy4.services.ContractServices;
import com.casestudy4.services.CustomerServices;
import com.casestudy4.services.EmployeeServices;
import com.casestudy4.services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractServices contractServices;

    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private ServiceServices serviceServices;

    @ModelAttribute("employees")
    private List<Employee> employees(){
        return employeeServices.findAll();
    }

    @ModelAttribute("customers")
    private List<Customer> customers(){
        return customerServices.findAll();
    }

    @ModelAttribute("service")
    private List<Service> services(){
        return serviceServices.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(value = 3)Pageable pageable){
        model.addAttribute("contractList", contractServices.findAll(pageable));
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("createCon",new Contract());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(Contract contract){
        contractServices.save(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        contractServices.delete(id);
        return "redirect:/contract/list";
    }

    @GetMapping("/using")
    public String listUsing(@PageableDefault(value = 3) Pageable pageable, Model model){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Page<Contract> listUsing = contractServices.getListUsingCustomer(date, pageable);
        model.addAttribute("listUsing",listUsing);
        return "/customer/using";
    }
}
