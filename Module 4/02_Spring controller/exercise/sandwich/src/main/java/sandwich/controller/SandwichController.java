package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @PostMapping("/save")
    public String save(@RequestParam String condiment, Model model){
        model.addAttribute("condiment", condiment);
        return "/show";
    }
}
