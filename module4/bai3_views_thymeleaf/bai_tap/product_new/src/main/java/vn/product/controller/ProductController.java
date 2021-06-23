package vn.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.product.model.Product;
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
    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("prodcuct", new Product());
        return "create";
    }
    @PostMapping(value = "/save")
    public String save(Product product) {
        service.save(product);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        System.out.println("abc");
        System.out.println(service.findById(id));
        model.addAttribute("product", service.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update" )
    public String update(Product product, RedirectAttributes redirectAttributes) {
        service.update(product.getId(),product);
        return  "redirect:/";
    }

    @GetMapping(value = "/{id}delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product",service.findById(id));
        return "delete";
    }

    @PostMapping(value = "delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        service.delete(product.getId());
        redirectAttributes.addFlashAttribute("susscess", "Removed product successfully");
        return "list";
    }

}
