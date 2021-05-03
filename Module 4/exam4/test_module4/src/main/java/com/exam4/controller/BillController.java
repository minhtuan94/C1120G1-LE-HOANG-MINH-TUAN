package com.exam4.controller;

import com.exam4.entity.Bill;
import com.exam4.entity.Product;
import com.exam4.entity.ProductType;
import com.exam4.service.BillService;
import com.exam4.service.ProductService;
import com.exam4.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @ModelAttribute("products")
    public List<Product> productList(){
        return productService.findAll();
    }
    @ModelAttribute("productTypes")
    public List<ProductType> productTypeList(){
        return productTypeService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model, Pageable pageable){
        model.addAttribute("billList", billService.findAll(pageable));
        return "/bill/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("bill",new Bill());
        model.addAttribute("products",this.productService.findAll());
        model.addAttribute("productTypes",this.productTypeService.findAll());
        return "/bill/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute(name = "bill") Bill bill, BindingResult bindingResult, Model model,
                       @RequestParam(name = "type") Integer type,RedirectAttributes redirectAttributes){
        bill.getProduct().setProductType(this.productTypeService.findById(type));
        new Bill().validate(bill,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("type",type);
            return "/bill/create";
        } else {
            bill.setTotal(this.billService.getTotalMoney(bill));
            billService.save(bill);
            redirectAttributes.addFlashAttribute("message", "Update success");
            return "redirect:/bill/list";
        }
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("bill", billService.findById(id));
        return "/bill/edit";
    }
}
