package vn.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.product.service.ProductService;
import vn.product.service.ProductServiceImpl;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("products", service.findAll());
        return "list";
    }
}
