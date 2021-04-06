package blog.blog.controller;

import blog.blog.entity.Blog;
import blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "/home";
    }

    @GetMapping("/blog/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        blog.setDate(timestamp);
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @GetMapping("/blog/delete")
    public String delete(@RequestParam Integer id){
        blogService.delete(id);
        return "redirect:/";
    }


    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
