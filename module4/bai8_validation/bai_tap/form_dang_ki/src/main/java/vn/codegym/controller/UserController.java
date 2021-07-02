package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.User;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "/view";
    }

    @PostMapping(value = "/validateUser")
    public String checkValidate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/view";
        }
        return "/result";
    }
}
