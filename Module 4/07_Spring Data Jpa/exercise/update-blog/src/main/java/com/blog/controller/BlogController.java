package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Category;
import com.blog.service.BlogService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> customerTypesList() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(value = 3) Pageable pageable){
//        model.addAttribute("blogs",blogService.findAll(pageable));
        model.addAttribute("blogs",blogService.sort(pageable));
        return "/blog/list";
    }

    @GetMapping("/search")
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, Pageable pageable) {
        if (!keyword.isPresent()) {
            model.addAttribute("blogs", blogService.findAll(pageable));
            return "blog/list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("blogs", blogService.search(keywordOld, pageable));
            return "blog/list";
        }
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog){
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        blogService.delete(id);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }
}
