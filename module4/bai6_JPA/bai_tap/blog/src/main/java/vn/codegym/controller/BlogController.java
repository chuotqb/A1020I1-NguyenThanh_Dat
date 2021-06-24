package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Blog;
import vn.codegym.service.BlogService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping (value = "/")
    public String showBlog(Model model){
        List<Blog> blogs = new ArrayList<>();
        blogs = blogService.findALl();
        model.addAttribute("blogs",blogs);
        return "home";
    }

    @GetMapping (value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping (value = "/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping(value = "/view/{id}")
    public String showView(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute("blog")Blog blog){
        blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        blogService.remove(id);
        return "redirect:/";
    }
}
