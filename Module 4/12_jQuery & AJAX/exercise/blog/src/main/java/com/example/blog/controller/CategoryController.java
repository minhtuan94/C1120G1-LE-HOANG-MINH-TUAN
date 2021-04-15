package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String homeCategory(Model model){
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/category/home";
    }
    @GetMapping("/category/create")
    public String create(Model model){
        model.addAttribute( "category",new Category() );
        return "/category/create";
    }
    @GetMapping("/category/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute( "category", categoryService.findCategoryById( id ) );
        return "/category/edit";
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable Integer id){
        categoryService.deleteCategory( id );
        return "redirect:/category";
    }
    @PostMapping("/category/save")
    public String save(@ModelAttribute Category category){
        categoryService.saveCategory( category );
        return "redirect:/category";
    }
}