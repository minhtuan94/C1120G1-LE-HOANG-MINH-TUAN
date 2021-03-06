package com.casestudy4.controller;

import com.casestudy4.entity.*;
import com.casestudy4.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceServices serviceServices;

    @Autowired
    private RentTypeServices rentTypeServices;

    @Autowired
    private ServiceTypeServices serviceTypeServices;

    @ModelAttribute("rentType")
    public List<RentType> rentTypes() {
        return rentTypeServices.findAllRentTypeService();
    }

    @ModelAttribute("serviceType")
    public List<ServiceType> serviceTypes() {
        return serviceTypeServices.findAllServiceType();
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("serviceList", serviceServices.sort(pageable));
        return "/service/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("service", new Service());
        return "/service/create";
    }

    @PostMapping("/save")
    public String save(@Validated Service service, BindingResult bindingResult) {
        this.serviceServices.checkServiceCode(service,bindingResult);
        if(bindingResult.hasErrors()){
            return "service/create";
        } else {
            serviceServices.save(service);
            return "redirect:/service/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String goEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("service", serviceServices.findById(id));
        return "/service/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        serviceServices.delete(id);
        return "redirect:/service/list";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("viewSer", serviceServices.findById(id));
        return "/service/view";
    }

    @GetMapping("/search")
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, Pageable pageable, RedirectAttributes redirectAttributes) {
        if (!keyword.isPresent()) {
            model.addAttribute("serviceList", serviceServices.findAll(pageable));
            redirectAttributes.addFlashAttribute("message","Kh??ng c?? d??? li???u");
            return "service/list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("serviceList", serviceServices.search(keywordOld, pageable));
            return "service/list";
        }
    }

}
