package controller;

import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.StudentService;
import services.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/students")
    public String getStudentPage(Model model){
        model.addAttribute("listStudent", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/student/create")
    public ModelAndView createStudentPage(Model model){
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("PHP");
        subjects.add("C#");
        subjects.add("NodeJs");
        model.addAttribute("subjects", subjects);
        return new ModelAndView("student/create", "student", new Student());
    }

    @PostMapping("/student/create")
    public String saveStudent(@ModelAttribute Student student,
                              RedirectAttributes redirectAttributes
                              ){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Them moi thanh cong");
        return "redirect:/students";
    }
}
