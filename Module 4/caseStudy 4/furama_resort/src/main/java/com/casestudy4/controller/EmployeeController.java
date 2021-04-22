package com.casestudy4.controller;

import com.casestudy4.entity.*;
import com.casestudy4.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private PositionServices positionServices;

    @Autowired
    private DivisionServices divisionServices;

    @Autowired
    private EducationDegreeServices educationDegreeServices;

    @Autowired
    private EmployeeServices employeeServices;

    @ModelAttribute("position")
    public List<Position> positionList(){
        return positionServices.findAllPosition();
    }

    @ModelAttribute("division")
    public List<Division> divisionList(){
        return divisionServices.findAllDivision();
    }

    @ModelAttribute("educationDegree")
    public List<EducationDegree> educationDegreeList(){
        return educationDegreeServices.findAllEducationDegree();
    }

    @GetMapping("/list")
    public String showList(Model model,@PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("employeeList",employeeServices.sort(pageable));
        return "/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("createEm",new Employee());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String save(Employee employee){
        employeeServices.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("editEm",employeeServices.findById(id));
        return "/employee/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        employeeServices.delete(id);
        return "redirect:/employee/list";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("viewEm",employeeServices.findById(id));
        return "/employee/view";
    }

    @GetMapping("/search")
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, Pageable pageable) {
        if (!keyword.isPresent()) {
            model.addAttribute("employeeList", employeeServices.findAll(pageable));
            return "employee/list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("employeeList", employeeServices.search(keywordOld, pageable));
            return "employee/list";
        }
    }

}
