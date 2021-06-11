package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping(value = "/showForm")
    public String showForm() {
        return "index";
    }
    @GetMapping(value = "/calculation")
    public String add(@RequestParam(value = "numberA", required = true) int numberA,
                      @RequestParam(value = "numberB", required = true) int numberB,
                      @RequestParam(value = "operator", required = true) String operator,
                      Model model
    ){
        int result = 0;
        switch (operator){
            case "Addition(+)":
                result = numberA+numberB;
                break;
            case "Subtraction(-)":
                result = numberA-numberB;
                break;
            case "Multiplication(X)":
                result = numberA*numberB;
                break;
            case "Division(/)":
                if (numberB != 0 ){
                    result = numberA/numberB;
                    break;
                }
                else {
                    throw new RuntimeException("Can't divide by zero");
                }
            default:
                throw new IllegalStateException("Unexpected value: " + operator);

        }
        model.addAttribute("result",result);
        return "index";
    }
}
