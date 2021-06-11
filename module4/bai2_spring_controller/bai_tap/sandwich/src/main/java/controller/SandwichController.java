package controller;

import model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SandwichController {
  @GetMapping("/create")
    public ModelAndView showCreateForm(){
      ModelAndView modelAndView = new ModelAndView("/create");
      modelAndView.addObject("sandwich",new Sandwich());
      modelAndView.addObject("condimentArray", new String[]{"Lettuce","Tomato","Mustard","Sprouts"});
      return modelAndView;
  }

  @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("sandwich") Sandwich sandwich){
      ModelAndView modelAndView = new ModelAndView("/display");
      modelAndView.addObject("sandwich", sandwich);
      modelAndView.addObject("condimentArray",sandwich.getCondiment());
      return modelAndView;
  }

}
