package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String showCalculator(){
        return "index";
    }
    @GetMapping("/result")
    public String call(@RequestParam(value = "usd", required = true) int usd, Model model){
        int vnd;
        vnd = 22000*usd;
        model.addAttribute("vnd",vnd);
        return "index";
    }
}
