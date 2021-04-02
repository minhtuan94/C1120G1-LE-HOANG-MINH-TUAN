package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import product.model.Product;
import product.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("products",productService.findAllProduct());
        return "/home";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @GetMapping("/product/delete")
    public String delete(@RequestParam Integer id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
}
