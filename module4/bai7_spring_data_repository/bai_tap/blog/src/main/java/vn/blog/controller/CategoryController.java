package vn.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.blog.model.Category;
import vn.blog.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category")
    public String showCategory(@PageableDefault Pageable pageable,Model model){
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "category/view";
    }

    @GetMapping(value = "/category/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping(value = "/category/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","Create Category: " + category.getName()+" was Successfully");
        return "redirect:/category";
    }

    @GetMapping(value = "/category/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, RedirectAttributes redirectAttributes, @PageableDefault Pageable pageable){
        Category category = categoryService.findbyId(id);
//        redirectAttributes.addFlashAttribute("categories",categoryService.findAll(pageable));
        redirectAttributes.addFlashAttribute("category",category);
        redirectAttributes.addFlashAttribute("action","edit");
        return "redirect:/category";
    }

    @PostMapping(value = "/category/edit")
    public String save(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping(value = "/category/delete/{id}")
    public String showFormDelete(@PathVariable("id") int id, RedirectAttributes redirectAttributes, @PageableDefault Pageable pageable){
        Category category = categoryService.findbyId(id);
        redirectAttributes.addFlashAttribute("category",category);
        redirectAttributes.addFlashAttribute("messageDelete","Do you want delete category: "+category.getName()+" ?");
        redirectAttributes.addFlashAttribute("action","delete");
        return "redirect:/category";
    }

    @PostMapping(value = "/category/delete")
    public String remove(@RequestParam("id") int id){
        categoryService.remove(id);
        return "redirect:/category";
    }
}
