package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.codegym.service.BlogService;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

}
