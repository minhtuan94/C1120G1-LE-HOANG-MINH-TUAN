package calculation.controller;

import calculation.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showCalc(){
        return "/home";
    }

    @PostMapping("/calc")
    public String equal(@RequestParam("num1") long num1, @RequestParam long num2,@RequestParam String calc, Model model){
        long result = calculatorService.calculator(num1,num2,calc);
        model.addAttribute("result",result);
        return "/home";
    }
}
