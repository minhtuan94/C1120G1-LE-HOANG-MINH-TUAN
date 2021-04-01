package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

//    @PostMapping("/login")
    @RequestMapping(value = "/login")
    public String login(@RequestParam(name = "username") String user, @RequestParam String password, Model model){
        if ("admin".equals(user) && "123456".equals(password)){
            model.addAttribute("username", user);
            return "result";
        }else {
            return "index";
        }

    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable int id){
        System.out.println(id);
        return null;
    }
}
