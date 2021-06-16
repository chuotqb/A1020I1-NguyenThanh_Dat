package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.ProductService;
import service.ProductServiceImpl;

@Controller
public class ProductController {
    private ProductService service = new ProductServiceImpl();
    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("products", service.findAll());
        return "list";
    }
}
