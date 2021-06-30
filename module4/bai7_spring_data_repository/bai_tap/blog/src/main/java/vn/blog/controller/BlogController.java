package vn.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.blog.model.Blog;
import vn.blog.model.Category;
import vn.blog.service.BlogService;
import vn.blog.service.CategoryService;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/blog")
    public String showBlog(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("blogs",blogService.findAll(pageable));
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "blog/view";
    }

    @GetMapping(value = "/blog/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping(value = "/blog/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Create new blog was Successfully");
        return "redirect:/blog";
    }

    @GetMapping(value = "/blog/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model, @PageableDefault Pageable pageable){
        Blog blog = blogService.findbyId(id);
        model.addAttribute("blogs",blogService.findAll(pageable));
        model.addAttribute("blog",blog);
        model.addAttribute("action","edit");
        return "/blog/view";
    }

    @PostMapping(value = "/blog/edit")
    public String save(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping(value = "/blog/delete/{id}")
    public String showFormDelete(@PathVariable("id") int id, Model model, @PageableDefault Pageable pageable){
        Blog blog = blogService.findbyId(id);
        model.addAttribute("categories",blogService.findAll(pageable));
        model.addAttribute("category",blog);
        model.addAttribute("messageDelete","Do you want delete this blog ?");
        model.addAttribute("action","delete");
        return "/blog/view";
    }

    @PostMapping(value = "/blog/delete")
    public String remove(@RequestParam("id") int id){
        blogService.remove(id);
        return "redirect:/blog";
    }

}
