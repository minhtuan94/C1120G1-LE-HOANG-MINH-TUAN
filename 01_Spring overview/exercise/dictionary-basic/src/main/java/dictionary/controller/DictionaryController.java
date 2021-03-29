package dictionary.controller;

import dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String dictionary(){
        return "/home";
    }

    @PostMapping("/dic")
    public String dic(@RequestParam String eng, Model model){
        String result = dictionaryService.search(eng);
        model.addAttribute("result", result);
        return "/result";
    }
}
