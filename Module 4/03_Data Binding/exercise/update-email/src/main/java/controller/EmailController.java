package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/")
    public String showEmail(Model model){
        Email email = new Email();
        model.addAttribute("email",email);
        return "/home";
    }

    @PostMapping("/email")
    public String submit(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("email", email);
        return "/home";
    }
}