package com.borrowbook.controller;

import com.borrowbook.model.Book;
import com.borrowbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("list","bookList", bookService.findAll());
    }

    @GetMapping("/book/{id}/borrow")
    public String borrow(@PathVariable int id, Model model, RedirectAttributes redirect){
        Book book = bookService.findById(id);
        if (book.getAmount() > 0){
            book.setAmount(book.getAmount() - 1);
            bookService.save(book);
            redirect.addFlashAttribute("success", "Mượn sách thành công !!");
        } else {
            redirect.addFlashAttribute("success", "Hết sách !!");
        }
        model.addAttribute("bookList", bookService.findAll());
        return "redirect:/";
    }

    @GetMapping("/book/return")
    public ModelAndView giveBack(){
        return new ModelAndView("borrow");
    }

    @PostMapping("/book/borrow")
    public String giveBackBook(@RequestParam String bookCode, Model model){
        Book book = bookService.findByCode(bookCode);
        if (book == null){
            model.addAttribute("message", "Không tìm thấy !!");
            return "borrow";
        } else {
            book.setAmount(book.getAmount() + 1);
            bookService.save(book);
            model.addAttribute("message","Trả sách thành công !!");
        }
        return "borrow";
    }
}
