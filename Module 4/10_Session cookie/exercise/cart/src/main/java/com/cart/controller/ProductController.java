package com.cart.controller;

import com.cart.entity.Product;
import com.cart.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String productList(Model model){
        model.addAttribute("product",productService.findAll());
        return "list";
    }

    @GetMapping("/view/{id}")
    public  String viewProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }

    @GetMapping("add/{id}")
    public String addProduct(@ModelAttribute("cart")Map<Product,Integer> cart,Model model,@PathVariable Integer id){
        Product product = productService.findById(id);
        if (cart.get(product)==null){
            cart.put(product,1);
        }else {
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }
        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public String deleteForm(@PathVariable Integer id, Model model,@ModelAttribute("cart") Map<Product,Integer> cart){
        cart.remove(productService.findById(id));
        model.addAttribute("cart",cart);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String cartList(Model model,@ModelAttribute("cart") Map<Product,Integer> cart){
        model.addAttribute("cart",cart);
        model.addAttribute("price",productService.totalPrice(cart));
        return "cart";
    }
    @GetMapping("cart/delete")
    public String deleteProduct(@ModelAttribute("cart") Map<Product,Integer> cart){
        cart.clear();
        return "redirect:/";
    }
    @GetMapping("/buy")
    public String buy(@ModelAttribute("cart") Map<Product,Integer> cart,Model model){
        model.addAttribute("cart",cart);
        return "buy";
    }
    @ModelAttribute("cart")
    public Map<Product,Integer> cart(){
        return new HashMap<>();
    }
}