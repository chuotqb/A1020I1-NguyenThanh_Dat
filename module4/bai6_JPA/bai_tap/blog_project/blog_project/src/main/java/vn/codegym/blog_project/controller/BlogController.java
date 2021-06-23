package vn.codegym.blog_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.codegym.blog_project.service.BlogService;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
}
