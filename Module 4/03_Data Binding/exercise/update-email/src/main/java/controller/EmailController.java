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
        model.addAttribute("email", new Email("English","25","Enable spams filter","Thor"));
        return "/home";
    }

    @PostMapping("/email")
    public String submit(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("spams", email.getSpamsFilter());
        model.addAttribute("sign", email.getSignature());
        return "/home";
    }
}